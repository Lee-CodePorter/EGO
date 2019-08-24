package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import top.leesh.mapper.ProdCommMapper;
import top.leesh.pojo.ProdComm;
import top.leesh.pojo.User;
import top.leesh.service.IProdCommService;
import top.leesh.service.IUserService;
import top.leesh.vo.PageParam;
import top.leesh.vo.ProdCommListVo;
import top.leesh.vo.ProdCommVo;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * <p>
 * 商品评论 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class ProdCommServiceImpl extends ServiceImpl<ProdCommMapper, ProdComm> implements IProdCommService
{
    @Autowired
    private  ProdCommMapper commMapper;


    @Autowired
    private MapperFacade mapperFacade;

    @Reference
    private IUserService userService;


    @Override
    public IPage<ProdComm> getPage(Page<ProdComm> commPage, ProdComm comm)
    {
        //创建条件对象
        QueryWrapper<ProdComm> wrapper = new QueryWrapper<>();
        return commMapper.selectPage(commPage,wrapper);
    }

    /**
     *@Description //TODO   获取商品的评论
     *@Param [prodId]
     *@Return java.util.List<top.leesh.vo.ProdCommVo>
     */
    @Override
    public ProdCommVo getProdCommById(Integer prodId)
    {
        //创建vo对象
        ProdCommVo commVo=new ProdCommVo();

        //获得商品的总评论数
        //创建lambda条件对象
        LambdaQueryWrapper<ProdComm> allCount = new LambdaQueryWrapper<>();
        //id相等
        allCount.eq(ProdComm::getProdId,prodId);
        //查询条数
        Integer count = commMapper.selectCount(allCount);
        //vo对象设置值
        commVo.setNumber(count>0?count:0);

        //获得商品好评条数
        //创建lambda条件对象
        LambdaQueryWrapper<ProdComm> praise = new LambdaQueryWrapper<>();
        //id相等
        praise.eq(ProdComm::getProdId,prodId);
        //评价(0好评 1中评 2差评)
        praise.eq(ProdComm::getEvaluate,"0");
        //查询数据库
        Integer praiseCount = commMapper.selectCount(praise);
        //设置vo对象的值
        commVo.setPraiseNumber(praiseCount>0?praiseCount:0);

        //获得商品的差评条数
        LambdaQueryWrapper<ProdComm> badReview = new LambdaQueryWrapper<>();
        //id相等
        badReview.eq(ProdComm::getProdId,prodId);
        //评价(0好评 1中评 2差评)
        badReview.eq(ProdComm::getEvaluate,"2");
        //查询数据库
        Integer badCount = commMapper.selectCount(badReview);
        //设置值
        commVo.setNegativeNumber(badCount>0?badCount:0);


        //获得商品的中评
        LambdaQueryWrapper<ProdComm> secCount = new LambdaQueryWrapper<>();
        //id
        secCount.eq(ProdComm::getProdId,prodId);
        ////评价(0好评 1中评 2差评)
        secCount.eq(ProdComm::getEvaluate,"1");
        //查询数据库
        Integer  secondCount= commMapper.selectCount(secCount);
        //设置值
        commVo.setSecondaryNumber(secondCount>0?secondCount:0);


        //获得商品评论有图片的条数
        LambdaQueryWrapper<ProdComm> picCount = new LambdaQueryWrapper<>();
        //id
        picCount.eq(ProdComm::getProdId,prodId);
        //判断有图json是否为空
        picCount.isNull(ProdComm::getPics);
        //查询数据库
        Integer pictureCount = commMapper.selectCount(picCount);
        //设置值
        commVo.setPicNumber(pictureCount>0?pictureCount:0);

        //判断评论总条数为否为0
        //为0，好好评率为0
        if(count==0)
        {
            commVo.setPositiveRating(new BigDecimal(0));
        }
        //不为0继续计算
        else
        {
            //计算好评率
            BigDecimal good = new BigDecimal(praiseCount);

            //好评率
            BigDecimal avorablerRate = good.divide(new BigDecimal(count),2,RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));

            //设置vo
            commVo.setPositiveRating(avorablerRate);
        }

        return commVo;
    }

    /**
     *@Description //TODO 查询商品评论详情
     *@Param [prodId, evaluate]
     *@Return java.util.List<top.leesh.vo.ProdCommListVo>
     */
    @Override
    public PageParam<ProdCommListVo> getProdCommList(Page<ProdComm> page, Integer prodId, Integer evaluate)
    {
        //判断用户查询的类型
        //查询所有评论
        switch (evaluate)
        {
            //全部评论
            case    -1 :    return getAllCommon(page,prodId);
            //好评
            case    0  :    return getGoodCoom(page,prodId);
            //中评
            case    1  :    return getSecCommon(page,prodId);
            //差评
            case    2  :    return getBadCommon(page,prodId);
            //有图的
            case    3  :    return getGotPic(page,prodId);
            default: return null;
        }
    }

    /**
     *@Description //TODO   差评
     *@Param [prodId]
     *@Return java.util.List<top.leesh.vo.ProdCommListVo>
     */
    private PageParam<ProdCommListVo> getBadCommon(Page<ProdComm> page,Integer prodId)
    {
        LambdaQueryWrapper<ProdComm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProdComm::getProdId,prodId).eq(ProdComm::getEvaluate,2);

        return getPageParam(page, wrapper);
    }

    /**
     *@Description //TODO     有图的
     *@Param [prodId]
     *@Return java.util.List<top.leesh.vo.ProdCommListVo>
     */
    private PageParam<ProdCommListVo> getGotPic(Page<ProdComm> page,Integer prodId)
    {
        LambdaQueryWrapper<ProdComm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProdComm::getProdId,prodId).isNotNull(ProdComm::getPics);

        return getPageParam(page, wrapper);
    }

    /**
     *@Description //TODO   中评
     *@Param [prodId]
     *@Return java.util.List<top.leesh.vo.ProdCommListVo>
     */
    private PageParam<ProdCommListVo> getSecCommon(Page<ProdComm> page,Integer prodId)
    {
        LambdaQueryWrapper<ProdComm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProdComm::getProdId,prodId).eq(ProdComm::getEvaluate,1);

        return getPageParam(page, wrapper);
    }

    /**
     *@Description //TODO 好评
     *@Param [prodId]
     *@Return java.util.List<top.leesh.vo.ProdCommListVo>
     */
    private PageParam<ProdCommListVo> getGoodCoom(Page<ProdComm> page,Integer prodId)
    {
        LambdaQueryWrapper<ProdComm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProdComm::getProdId,prodId).eq(ProdComm::getEvaluate,0);

        return getPageParam(page, wrapper);
    }


    /**
     *@Description //TODO    评论全查询
     *@Param [prodId]
     *@Return java.util.List<top.leesh.vo.ProdCommListVo>
     */
    private PageParam<ProdCommListVo> getAllCommon(Page<ProdComm> page,Integer prodId)
    {

        LambdaQueryWrapper<ProdComm> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ProdComm::getPics,prodId).eq(ProdComm::getStatus,1);

        return getPageParam(page, wrapper);
    }
    /**
     *@Description //TODO   提取查询公用方法
     *@Param [page, wrapper]
     *@Return top.leesh.vo.PageParam<top.leesh.vo.ProdCommListVo>
     */
    private PageParam<ProdCommListVo> getPageParam(Page<ProdComm> page, LambdaQueryWrapper<ProdComm> wrapper) {
        IPage<ProdComm> commIPage = commMapper.selectPage(page, wrapper);
        List<ProdComm> records = commIPage.getRecords();
        List<ProdCommListVo> commListVos = mapperFacade.mapAsList(records, ProdCommListVo.class);
        //没有实现对用户的查询
        for (ProdCommListVo prodCommLittleVo : commListVos) {
//            User user = userService.getById(prodCommLittleVo.getUserId());
//            System.out.println(userService);
//            userService.
            User user = userService.getById(prodCommLittleVo.getUserId());
            System.out.println(prodCommLittleVo.getUserId());
            System.out.println(user);
            prodCommLittleVo.setNickName(user.getNickName());
            prodCommLittleVo.setPic(user.getPic());
        }
//        return new PageParam<ProdCommListVo>(page.getCurrent(), page.getSize(), page.getTotal());
        PageParam<ProdCommListVo> pageParam = new PageParam<>();
        pageParam.setCurrent(page.getCurrent());
        pageParam.setSize(page.getSize());
        pageParam.setPages(page.getTotal());
//        pageParam.set page.getTotal()
        pageParam.setRecords(commListVos);
        return pageParam;
    }

    public static void main(String[] args)
    {
        //计算好评率
        BigDecimal good = new BigDecimal(7);
        good.setScale(2);
//        good.setScale(2);
        //好评率
        BigDecimal avorablerRate = good.divide(new BigDecimal(19),2, RoundingMode.HALF_EVEN).multiply(new BigDecimal(100));
        System.out.println(avorablerRate);

    }
}

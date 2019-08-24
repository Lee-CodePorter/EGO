package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.util.StringUtils;
import top.leesh.service.IProdService;
import top.leesh.mapper.*;
import top.leesh.pojo.*;
import java.util.List;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class ProdServiceImpl extends ServiceImpl<ProdMapper, Prod> implements IProdService
{
    public static final String []PRODNOCONTENTRESULT = new String[] {
            "prod_id",
            "prod_name",
            "price",
            "ori_price",
            "brief",
            "pic",
            "category_id",
            "sold_num",
            "total_stocks",
            "delivery_mode",
            "putaway_time"
    };


    /**
     *@Description //TODO 自动注入mapper接口
     *@Param  
     *@return 
     */
    @Autowired
    private ProdMapper prodMapper;


    @Autowired
    private ProdPropMapper prodPropMapper;


    @Autowired
    private ProdPropValueMapper prodPropValueMapper;

    @Autowired
    private  SkuMapper skuMapper;

    @Autowired
    private ProdTagReferenceMapper referenceMapper;

    /**
     *@Description //TODO 获取所有商品信息
     *@Param [page, prod] 
     *@return com.baomidou.mybatisplus.core.metadata.IPage<Prod>
     */
    @Override
    public IPage<Prod> getPage(Page<Prod> page, Prod prod)
    {
        //构建条件
        QueryWrapper<Prod> wrapper = new QueryWrapper<>();

        //模糊查询
        wrapper.like(StringUtils.hasText(prod.getProdName()),"prod_name",prod.getProdName());

        //上架情况
        wrapper.eq(prod.getStatus()!=null,"status",prod.getStatus());

        //商品状态必须为有效(删除的商品)
        wrapper.ne("status",-1);

        //查询mapper
        IPage<Prod> prodIPage = prodMapper.selectPage(page,wrapper);

        //返回查询结果
        return prodIPage;
    }

    /**
     *@Description //TODO 添加规格
     *@Param [prodProp]
     *@Return java.lang.Boolean
     */
    @Override
    public Boolean saveProdVlue(ProdProp prodProp)
    {
        //创建条件对象
        QueryWrapper<ProdProp> wrapper = new QueryWrapper<>();
        //查找prop_name是否存在
        wrapper.eq("prop_name",prodProp.getPropName());
        Integer count = prodPropMapper.selectCount(wrapper);
        if(count>0)
        {
            throw  new RuntimeException("该属性已存在!");
        }

//        prodProp.setShopId(prodProp.getPropId());

        int insert = prodPropMapper.insert(prodProp);


        List<ProdPropValue> propValues = prodProp.getProdPropValues();

       if(propValues!=null&&propValues.size()>0)
       {
           for (ProdPropValue propValue : propValues)
           {
               propValue.setPropId(prodProp.getPropId());
               prodPropValueMapper.insert(propValue);

           }
       }
        return insert>0;
    }

    /**
     *@Description //TODO 查询sole里面的数据
     *@Param []
     *@Return java.util.List<top.leesh.pojo.Prod>
     */
    @Override
    public List<Prod> getProdSolrVoList()
    {
        QueryWrapper<Prod> eq = new QueryWrapper<Prod>().select(PRODNOCONTENTRESULT).eq("status",1);
        List<Prod> prods = prodMapper.selectList(eq);
        for (Prod prod : prods) {
            QueryWrapper<ProdTagReference> queryWrapper = new QueryWrapper<ProdTagReference>();
            queryWrapper.select("tag_id").eq("prod_id", prod.getProdId());
            List<Object> tags = referenceMapper.selectObjs(queryWrapper);
            prod.setTags(tags);
        }
        return prods;
    }

    /**
     *@Description //TODO  获取商品详情信息(包括sku)
     *@Param [prodId]
     *@Return top.leesh.pojo.Prod
     */
    @Override
    public Prod getProdAndSkuById(Long prodId)
    {
        //查询商品详情
        Prod prod = prodMapper.selectById(prodId);
        //获取商品sku
        List<Sku> skuList = getSkuList(prod.getProdId());
        prod.setSkuList(skuList);
        return prod;
    }
    private List<Sku> getSkuList(Long id) {
        QueryWrapper<Sku> queryWrapper = new QueryWrapper<Sku>();
        queryWrapper.eq("prod_id", id);
        return skuMapper.selectList(queryWrapper);
    }
}

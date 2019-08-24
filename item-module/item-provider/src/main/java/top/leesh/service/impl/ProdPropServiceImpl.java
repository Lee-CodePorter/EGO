package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import top.leesh.pojo.ProdPropValue;
import top.leesh.mapper.ProdPropMapper;
import top.leesh.pojo.ProdProp;
import top.leesh.mapper.ProdPropValueMapper;
import top.leesh.service.IProdPropService;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class ProdPropServiceImpl extends ServiceImpl<ProdPropMapper, ProdProp> implements IProdPropService
{

    @Autowired
    private ProdPropMapper prodPropMapper;

    @Autowired
    private ProdPropValueMapper prodPropValueMapper;


    @Override
    public IPage<ProdProp> getPage(Page<ProdProp> prodPropPage, ProdProp page)
    {
        //创建查询条件对象
        QueryWrapper<ProdProp> wrapper = new QueryWrapper<>();

        //设置查询条件(模糊查询)
        wrapper.like(StringUtils.hasText(page.getPropName()),"prop_name",page.getPropName());

        //属性结果
        IPage<ProdProp> propIPage = prodPropMapper.selectPage(prodPropPage, wrapper);

        //得到属性分页对象记录列表
        List<ProdProp> records = propIPage.getRecords();

        //循环集合
        for (ProdProp record : records)
        {
            //创建属性值搜索对象
            QueryWrapper<ProdPropValue> valueQueryWrapper = new QueryWrapper<>();
            //查询条件(当prod_prod的prop_id和prod_prop_value的prop_id)
            /**select * from prod_prop p1 prod_prop_value p2 where p1.prop_id=p2.prop_id*/
            valueQueryWrapper.eq("prop_id",record.getPropId());
            //查询属性值
            List<ProdPropValue> propValues = prodPropValueMapper.selectList(valueQueryWrapper);
            //将属性值设置到prod中
            record.setProdPropValues(propValues);
        }
        return propIPage;
    }

    //更新规格属性值
    @Override
    public Boolean updateValue(ProdProp prodProp)
    {
        System.out.println("规格"+prodProp);
        System.out.println("规格id"+prodProp.getPropId());
        //修改属性名
        //验证id是否为null

        //创建条件对象
        QueryWrapper<ProdProp> wrapper = new QueryWrapper<>();

        //添加条件
        wrapper.eq("prop_name",prodProp.getPropName());

        int updateIndex=0;


        LocalDateTime.now();


        //查询
        ProdProp prop = prodPropMapper.selectOne(wrapper);

        if(prop==null)
        {
            //根据id更新
            updateIndex=prodPropMapper.updateById(prodProp);
        }

        if(prop!=null)
        {
            throw  new RuntimeException("已经存在值");
        }


        //修改属性值
        List<ProdPropValue> propValues = prodProp.getProdPropValues();

        //删除已有的属性值
        int delete = prodPropValueMapper.deleteById(prodProp.getPropId());

        //添加属性值
        for (ProdPropValue propValue : propValues)
        {
            prodPropValueMapper.insert(propValue);
        }

        return updateIndex>0;
    }
}

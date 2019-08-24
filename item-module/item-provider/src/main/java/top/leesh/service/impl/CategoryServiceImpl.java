package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import top.leesh.mapper.CategoryMapper;
import top.leesh.pojo.Category;
import top.leesh.pojo.WeChatProdVo;
import top.leesh.service.ICategoryService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 产品类目 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService
{

    @Autowired
    private  CategoryMapper categoryMapper;

    @Autowired
    private SolrClient solrClient;

    /**
     *@Description //TODO      获得商品分类集合
     *@Param [parentId]
     *@Return java.util.List<top.leesh.pojo.Category>
     */
    @Override
    public List<Category> getCateGoryList(String parentId)
    {
        LambdaQueryWrapper<Category> wrapper = new LambdaQueryWrapper<>();
        wrapper.le(Category::getGrade,"2");
        return categoryMapper.selectList(wrapper);
    }

    @Override
    public List<WeChatProdVo> getProdListByParId(Long categoryId)
    {
        //搜索id匹配的商品
        SolrQuery solrQuery = new SolrQuery("category_id:"+categoryId);

        solrQuery.setRows(Integer.MAX_VALUE);


        List<WeChatProdVo> vo=null;


        try
        {
            QueryResponse query = solrClient.query(solrQuery);
            SolrDocumentList results = query.getResults();
            vo = getWeChatProdVo(results);
        }
        catch (SolrServerException | IOException e)
        {
            e.printStackTrace();
        }
        return vo;
    }
    private List<WeChatProdVo> getWeChatProdVo(SolrDocumentList results) {
        List<WeChatProdVo> vos = new ArrayList<>();
        for (SolrDocument solrDocument : results) {
            WeChatProdVo prodWechatVo = new WeChatProdVo();
            prodWechatVo.setProdId(solrDocument.getFieldValue("id").toString());
            prodWechatVo.setProdName(solrDocument.getFieldValue("prod_name").toString());
            prodWechatVo.setPrice(new BigDecimal(solrDocument.getFieldValue("prod_price").toString()));
            prodWechatVo.setPic(solrDocument.getFieldValue("prod_pic").toString());
            prodWechatVo.setProdCommNumber(0L);
            prodWechatVo.setPositiveRating(new BigDecimal(100.00));
            vos.add(prodWechatVo);
        }
        return vos;
    }
}

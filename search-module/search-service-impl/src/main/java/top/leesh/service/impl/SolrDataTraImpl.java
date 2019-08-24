package top.leesh.service.impl;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import com.alibaba.dubbo.config.annotation.Reference;
import ma.glasnost.orika.MapperFacade;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.leesh.pojo.Prod;
import top.leesh.pojo.Solr;
import top.leesh.service.IProdService;
import top.leesh.service.SolrDataTra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.service.impl
 * @createdate 2019/8/9 21:18
 */
@Service
public class SolrDataTraImpl implements SolrDataTra
{
    private static DocumentObjectBinder DOCUMENTOBJECTBINDER = new DocumentObjectBinder();
    /**
     *@Description //TODO  商品服务类
     *@Param
     *@Return
     */
    @Reference
    private IProdService prodService;

    /**
     *@Description //TODO   转换类工具
     *@Param
     *@Return
     */
    @Autowired
    private MapperFacade mapperFacade;

    /**
     *@Description //TODO solr客户端连接工具
     *@Param
     *@Return
     */
    @Autowired
    private SolrClient solrClient;


    /**
     *@Description //TODO    导入数据到solr
     *@Param []
     *@Return void
     */
    @Override
    public void importSolrData()
    {
        // 查询数据
        List<Prod> pords = prodService.getProdSolrVoList() ;
        // 导入到solr 里面
        List<Solr> prodVos = prod2ProdSolrVo(pords);
        //
        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();
        for (Solr prodSolrVo : prodVos) {
            // 将对象转化为doc
            docs.add(DOCUMENTOBJECTBINDER.toSolrInputDocument(prodSolrVo));
        }
        try {
            solrClient.add(docs);
            solrClient.commit();
            System.out.println("导入成功");
        } catch (SolrServerException | IOException e) {
            e.printStackTrace();
        }
    }

    private List<Solr> prod2ProdSolrVo(List<Prod> pords)
    {
        if(pords==null||pords.size()==0) {
            return null ;
        }
        List<Solr> prodSolrVos = new ArrayList<Solr>();
        for (Prod prod : pords) {
            // // 属性名称的复制 不管类型
            Solr prodSolrVo = mapperFacade.map(prod, Solr.class);

            prodSolrVo.setId(String.valueOf(prod.getProdId()));

            prodSolrVo.setProdPrice(prod.getPrice().floatValue());
            // 100    120
            prodSolrVo.setIsOnsale(prod.getPrice().floatValue()-prod.getOriPrice().floatValue() < 0);
            String deliveryMode = prod.getDeliveryMode();
            JSONObject parseObj = JSONUtil.parseObj(deliveryMode);
//			{"hasUserPickUp": false, "hasShopDelivery": true}
            Boolean hasUserPickUp = (Boolean) parseObj.get("hasUserPickUp");
//			Boolean hasShopDelivery = (Boolean) parseObj.get("hasShopDelivery");
            // 1:商品配送  2 用户自提
            prodSolrVo.setDeliveryModeWay(hasUserPickUp?2:1);
            //处理标签
            List<Object> tags = prod.getTags();
            List<Long> tagsLong = new ArrayList<Long>();
            tags.forEach((k)->tagsLong.add(Long.valueOf(k.toString())));
            prodSolrVo.setProdTags(tagsLong);
            prodSolrVo.setPutawayTimeDiff(prod.getPutawayTime().getTime());
            prodSolrVos.add(prodSolrVo);
        }
        return prodSolrVos;
    }
}

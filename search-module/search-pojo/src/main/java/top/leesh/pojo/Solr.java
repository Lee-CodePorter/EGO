package top.leesh.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;


import java.math.BigDecimal;
import java.util.List;

/**
 * @author 李书涵  solr导入数据的时候用的
 * @package_name: top.leesh.pojo
 * @createdate 2019/8/9 21:01
 */
@Data
public class Solr
{
    /**
     * 商品的id
     */
    @Field
    private String  id;
    /**
     * 商品的名称
     */
    @Field("prod_name")
    private String  prodName;
    /**
     * 商品的高亮名称
     */
    private String  prodNameHl;
    /**
     * 商品的价格
     */
    @Field("prod_price")
    private Float  prodPrice;
    /**
     * 商品的主图
     */
    @Field("prod_pic")
    private String  pic;
    /**
     * 商品的买点
     */
    @Field("prod_brief")
    private String  brief;
    /**
     * 商品的分类id
     */
    @Field("category_id")
    private String  categoryId;
    /**
     * 商品的销量
     */
    @Field("sold_num")
    private Long  soldNum;
    /**
     * 商品的库存
     */
    @Field("total_stocks")
    private Long  totalStocks;
    /**
     * 商品的配送方法
     */
    @Field("delivery_mode")
    private Integer  deliveryModeWay;
    /**
     * 商品是否打折
     */
    @Field("is_onsale")
    private Boolean  isOnsale;
    /**
     * 商品的标签
     */
    @Field("prod_tags")
    private List<Long> prodTags;
    /**
     * 商品的上架时间，使用差值
     */
    @Field("putaway_time")
    private Long  putawayTimeDiff;


}

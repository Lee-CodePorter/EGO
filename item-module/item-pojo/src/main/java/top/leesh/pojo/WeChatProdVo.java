package top.leesh.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 李书涵
 * @package_name: top.leesh.pojo
 * @createdate 2019/8/12 20:08
 */
@Data
public class WeChatProdVo implements Serializable
{
    private static final long serialVersionUID = -3344777465119945683L;

    /**
     * 商品的id
     */
    private String prodId;
    /**
     * 商品的名称
     */
    private String prodName;

    /**
     * 商品的价格
     */
    private BigDecimal price;
    /**
     * 商品的图片
     */
    private String pic;

    /**
     * 商品的评论数量
     */
    private Long prodCommNumber;
    /**
     * 商品的好评
     */
    private BigDecimal positiveRating;
}

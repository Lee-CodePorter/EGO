package top.leesh.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.vo
 * @createdate 2019/8/9 20:58
 */
@Data
public class ProdVo
{
//    /**
//     * 商品的id
//     */
//    private Long id;
//    /**
//     * 商品的主图
//     */
//    private String pic;
//    /**
//     * 商品的名称
//     */
//    private String prodName;
//    /**
//     * 商品的价格
//     */
//    private BigDecimal price;



    /**
     * 商品的id
     */
    private Long prodId;
    /**
     * 商品的主图
     */
    private String pic;

    private String imgs;

    private String content;

    private String brief;

    /**
     * 商品的名称
     */
    private String prodName;
    /**
     * 商品的价格
     */
    private BigDecimal price;
    // 扩展
    private List<SkuVo> skuList;
}

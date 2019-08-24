package top.leesh.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 李书涵
 * @package_name: top.leesh.vo
 * @createdate 2019/8/12 22:21
 */
@Data
public class SkuVo
{
    /**
     * skuId ,页面上显示没有该值，但是添加购物车时有该值
     */
    private Long skuId;
    /**
     * sku的价格
     */
    private BigDecimal price;
    /**
     * sku的属性
     * 内存：16G;颜色:红
     */
    private String properties;
}

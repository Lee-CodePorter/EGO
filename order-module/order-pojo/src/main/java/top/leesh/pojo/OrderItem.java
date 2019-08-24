package top.leesh.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 订单项
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderItem对象", description="订单项")
public class OrderItem extends Model<OrderItem> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单项ID")
    @TableId(value = "order_item_id", type = IdType.AUTO)
    private Long orderItemId;

    @ApiModelProperty(value = "店铺id")
    private Long shopId;

    @ApiModelProperty(value = "订单order_number")
    private String orderNumber;

    @ApiModelProperty(value = "产品ID")
    private Long prodId;

    @ApiModelProperty(value = "产品SkuID")
    private Long skuId;

    @ApiModelProperty(value = "购物车产品个数")
    private Integer prodCount;

    @ApiModelProperty(value = "产品名称")
    private String prodName;

    @ApiModelProperty(value = "sku名称")
    private String skuName;

    @ApiModelProperty(value = "产品主图片路径")
    private String pic;

    @ApiModelProperty(value = "产品价格")
    private BigDecimal price;

    @ApiModelProperty(value = "用户Id")
    private String userId;

    @ApiModelProperty(value = "商品总金额")
    private BigDecimal productTotalAmount;

    @ApiModelProperty(value = "购物时间")
    private LocalDateTime recTime;

    @ApiModelProperty(value = "评论状态： 0 未评价  1 已评价")
    private Integer commSts;

    @ApiModelProperty(value = "推广员使用的推销卡号")
    private String distributionCardNo;

    @ApiModelProperty(value = "加入购物车时间")
    private LocalDateTime basketDate;


    @Override
    protected Serializable pkVal() {
        return this.orderItemId;
    }

}

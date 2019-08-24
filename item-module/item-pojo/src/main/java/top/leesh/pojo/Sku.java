package top.leesh.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 单品SKU表
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Sku对象", description="单品SKU表")
public class Sku extends Model<Sku> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单品ID")
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Long skuId;

    @ApiModelProperty(value = "商品ID")
    private Long prodId;

    @ApiModelProperty(value = "销售属性组合字符串 格式是p1:v1;p2:v2")
    private String properties;

    @ApiModelProperty(value = "原价")
    private BigDecimal oriPrice;

    @ApiModelProperty(value = "价格")
    private BigDecimal price;

    @ApiModelProperty(value = "商品在付款减库存的状态下，该sku上未付款的订单数量")
    private Integer stocks;

    @ApiModelProperty(value = "实际库存")
    private Integer actualStocks;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "记录时间")
    private Date recTime;

    @ApiModelProperty(value = "商家编码")
    private String partyCode;

    @ApiModelProperty(value = "商品条形码")
    private String modelId;

    @ApiModelProperty(value = "sku图片")
    private String pic;

    @ApiModelProperty(value = "sku名称")
    private String skuName;

    @ApiModelProperty(value = "商品名称")
    private String prodName;

    @ApiModelProperty(value = "版本号")
    private Integer version;

    @ApiModelProperty(value = "商品重量")
    private Double weight;

    @ApiModelProperty(value = "商品体积")
    private Double volume;

    @ApiModelProperty(value = "0 禁用 1 启用")
    private Integer status;

    @ApiModelProperty(value = "0 正常 1 已被删除")
    private Integer isDelete;


    @Override
    protected Serializable pkVal() {
        return this.skuId;
    }

}

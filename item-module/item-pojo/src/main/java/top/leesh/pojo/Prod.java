package top.leesh.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 商品
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Prod对象", description="商品")
public class Prod extends Model<Prod> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品ID")
    @TableId(value = "prod_id", type = IdType.AUTO)
    private Long prodId;

    @ApiModelProperty(value = "商品名称")
    private String prodName;

    @ApiModelProperty(value = "店铺id")
    private Long shopId;

    @ApiModelProperty(value = "原价")
    private BigDecimal oriPrice;

    @ApiModelProperty(value = "现价")
    private BigDecimal price;

    @ApiModelProperty(value = "简要描述,卖点等")
    private String brief;

    @ApiModelProperty(value = "详细描述")
    private String content;

    @ApiModelProperty(value = "商品主图")
    private String pic;

    @ApiModelProperty(value = "商品图片，以,分割")
    private String imgs;

    @ApiModelProperty(value = "默认是1，表示正常状态, -1表示删除, 0下架")
    private Integer status;

    @ApiModelProperty(value = "商品分类")
    private Long categoryId;

    @ApiModelProperty(value = "销量")
    private Integer soldNum;

    @ApiModelProperty(value = "总库存")
    private Integer totalStocks;

    @ApiModelProperty(value = "配送方式json见TransportModeVO")
    private String deliveryMode;

    @ApiModelProperty(value = "运费模板id")
    private Long deliveryTemplateId;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "录入时间")
    private Date createTime;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @DateTimeFormat(pattern ="yyyy-MM-dd HH:mm:ss" )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "上架时间")
    private Date putawayTime;

    @ApiModelProperty(value = "版本 乐观锁")
    private Integer version;

    @TableField(exist = false)
    private List<Object> tags;

    /**
     *@Description //TODO   扩展属性
     *@Param
     *@Return
     */
    @TableField(exist = false)
    private List<Sku> skuList;

    @Override
    protected Serializable pkVal() {
        return this.prodId;
    }

}

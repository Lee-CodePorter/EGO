package top.leesh.pojo;

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
 * 购物车
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Basket对象", description="购物车")
public class Basket extends Model<Basket> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "basket_id", type = IdType.AUTO)
    private Long basketId;

    @ApiModelProperty(value = "店铺ID")
    private Long shopId;

    @ApiModelProperty(value = "产品ID")
    private Long prodId;

    @ApiModelProperty(value = "SkuID")
    private Long skuId;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "购物车产品个数")
    private Integer basketCount;

    @ApiModelProperty(value = "购物时间")
    private Date basketDate;

    @ApiModelProperty(value = "满减活动ID")
    private Long discountId;

    @ApiModelProperty(value = "分销推广人卡号")
    private String distributionCardNo;


    @Override
    protected Serializable pkVal() {
        return this.basketId;
    }

}

package top.leesh.shop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Registration对象", description="")
public class Registration extends Model<Registration> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "挂号单id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "挂号单号")
    private String regNum;

    @ApiModelProperty(value = "用户id")
    private Integer uid;

    @ApiModelProperty(value = "医生id")
    private Integer did;

    @ApiModelProperty(value = "挂号费用")
    private BigDecimal amount;

    @ApiModelProperty(value = "是否支付")
    @TableField("isPay")
    private Integer isPay;

    @ApiModelProperty(value = "支付时间")
    private LocalDate payTime;

    @ApiModelProperty(value = "状态（1：待支付，2：待就诊，3：完成）")
    private Integer status;

    @ApiModelProperty(value = "挂号日期")
    private LocalDate createTime;

    @ApiModelProperty(value = "修改日期")
    private LocalDate updateTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

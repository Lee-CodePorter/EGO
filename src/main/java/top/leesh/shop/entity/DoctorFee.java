package top.leesh.shop.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="DoctorFee对象", description="")
public class DoctorFee extends Model<DoctorFee> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "费用id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "（1：普通，2：专家）")
    private Integer type;

    @ApiModelProperty(value = "费用")
    private BigDecimal amount;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

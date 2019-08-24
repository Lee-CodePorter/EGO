package top.leesh.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
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
@ApiModel(value="Doctor对象", description="")
public class Doctor extends Model<Doctor> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "医生id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "医生科室id")
    private Integer sId;

    @ApiModelProperty(value = "医生名称")
    private String name;

    @ApiModelProperty(value = "医生类别（1：普通，2：专家）")
    private Integer type;

    @ApiModelProperty(value = "医生的技能点")
    private String brief;

    @ApiModelProperty(value = "医生的头像")
    private String pic;

    @ApiModelProperty(value = "医生的年龄")
    private Integer age;

    @ApiModelProperty(value = "医生的删除状态")
    private Integer status;

    @ApiModelProperty(value = "医生的创建时间")
    private LocalDate createTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

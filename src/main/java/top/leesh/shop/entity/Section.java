package top.leesh.shop.entity;

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
@ApiModel(value="Section对象", description="")
public class Section extends Model<Section> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "科室id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "科室父id")
    private Integer pid;

    @ApiModelProperty(value = "科室名称")
    private String name;

    @ApiModelProperty(value = "科室等级")
    private Integer level;

    @ApiModelProperty(value = "科室的删除状态")
    private Integer status;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}

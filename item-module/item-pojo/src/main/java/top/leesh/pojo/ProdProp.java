package top.leesh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProdProp对象", description="")
public class ProdProp extends Model<ProdProp> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "属性id")
    @TableId(value = "prop_id", type = IdType.AUTO)
    private Long propId;

    @ApiModelProperty(value = "属性名称")
    private String propName;

    @ApiModelProperty(value = "ProdPropRule 1:销售属性(规格); 2:参数属性;")
    private Integer rule;

    @ApiModelProperty(value = "店铺id")
    private Long shopId;

    //添加商品属性值字段
    @TableField(exist = false)
    private List<ProdPropValue> prodPropValues;

    @Override
    protected Serializable pkVal() {
        return this.propId;
    }

}

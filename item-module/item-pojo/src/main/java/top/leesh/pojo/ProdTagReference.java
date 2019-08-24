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
 * 
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProdTagReference对象", description="")
public class ProdTagReference extends Model<ProdTagReference> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "分组引用id")
    @TableId(value = "reference_id", type = IdType.AUTO)
    private Long referenceId;

    @ApiModelProperty(value = "店铺id")
    private Long shopId;

    @ApiModelProperty(value = "标签id")
    private Long tagId;

    @ApiModelProperty(value = "商品id")
    private Long prodId;

    @ApiModelProperty(value = "状态(1:正常,0:删除)")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


    @Override
    protected Serializable pkVal() {
        return this.referenceId;
    }

}

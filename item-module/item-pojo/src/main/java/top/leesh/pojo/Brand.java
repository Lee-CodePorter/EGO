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
 * 品牌表
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Brand对象", description="品牌表")
public class Brand extends Model<Brand> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "brand_id", type = IdType.AUTO)
    private Long brandId;

    @ApiModelProperty(value = "品牌名称")
    private String brandName;

    @ApiModelProperty(value = "图片路径")
    private String brandPic;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "备注")
    private String memo;

    @ApiModelProperty(value = "顺序")
    private Integer seq;

    @ApiModelProperty(value = "默认是1，表示正常状态,0为下线状态")
    private Integer status;

    @ApiModelProperty(value = "简要描述")
    private String brief;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "记录时间")
    private Date recTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "品牌首字母")
    private String firstChar;


    @Override
    protected Serializable pkVal() {
        return this.brandId;
    }

}

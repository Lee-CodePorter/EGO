package top.leesh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 热搜
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="HotSearch对象", description="热搜")
public class HotSearch extends Model<HotSearch> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "hot_search_id", type = IdType.AUTO)
    private Long hotSearchId;

    @ApiModelProperty(value = "店铺ID 0为全局热搜")
    private Long shopId;

    @ApiModelProperty(value = "内容")
    private String content;

    @ApiModelProperty(value = "录入时间")
    private LocalDateTime recDate;

    @ApiModelProperty(value = "顺序")
    private Integer seq;

    @ApiModelProperty(value = "状态 0下线 1上线")
    private Integer status;

    @ApiModelProperty(value = "热搜标题")
    private String title;


    @Override
    protected Serializable pkVal() {
        return this.hotSearchId;
    }

}

package top.leesh.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 商品评论
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProdComm对象", description="商品评论")
public class ProdComm extends Model<ProdComm> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    @TableId(value = "prod_comm_id", type = IdType.AUTO)
    private Long prodCommId;

    @ApiModelProperty(value = "商品ID")
    private Long prodId;

    @ApiModelProperty(value = "订单项ID")
    private Long orderItemId;

    @ApiModelProperty(value = "评论用户ID")
    private String userId;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "掌柜回复")
    private String replyContent;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    @ApiModelProperty(value = "记录时间")
    private Date recTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "GMT+8")
    @ApiModelProperty(value = "回复时间")
    private Date replyTime;

    @ApiModelProperty(value = "是否回复 0:未回复  1:已回复")
    private Integer replySts;

    @ApiModelProperty(value = "IP来源")
    private String postip;

    @ApiModelProperty(value = "得分，0-5分")
    private Integer score;

    @ApiModelProperty(value = "有用的计数")
    private Integer usefulCounts;

    @ApiModelProperty(value = "晒图的json字符串")
    private String pics;

    @ApiModelProperty(value = "是否匿名(1:是  0:否)")
    private Integer isAnonymous;

    @ApiModelProperty(value = "是否显示，1:为显示，0:待审核， -1：不通过审核，不显示。 如果需要审核评论，则是0,，否则1")
    private Integer status;

    @ApiModelProperty(value = "评价(0好评 1中评 2差评)")
    private Integer evaluate;


    @Override
    protected Serializable pkVal() {
        return this.prodCommId;
    }

}

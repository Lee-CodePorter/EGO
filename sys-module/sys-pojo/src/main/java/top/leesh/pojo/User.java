package top.leesh.pojo;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户表")
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "真实姓名")
    private String realName;

    @ApiModelProperty(value = "用户邮箱")
    private String userMail;

    @ApiModelProperty(value = "登录密码")
    private String loginPassword;

    @ApiModelProperty(value = "支付密码")
    private String payPassword;

    @ApiModelProperty(value = "手机号码")
    private String userMobile;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "修改时间")
    private Date modifyTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "注册时间")
    private Date userRegtime;

    @ApiModelProperty(value = "注册IP")
    private String userRegip;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "最后登录时间")
    private Date userLasttime;

    @ApiModelProperty(value = "最后登录IP")
    private String userLastip;

    @ApiModelProperty(value = "备注")
    private String userMemo;

    @ApiModelProperty(value = "M(男) or F(女)")
    private String sex;

    @ApiModelProperty(value = "例如：2009-11-27")
    private String birthDate;

    @ApiModelProperty(value = "头像图片路径")
    private String pic;

    @ApiModelProperty(value = "状态 1 正常 0 无效")
    private Integer status;

    @ApiModelProperty(value = "用户积分")
    private Integer score;


    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

}

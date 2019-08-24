package top.leesh.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 李书涵 商品评论集合扩展类
 * @package_name: top.leesh.vo
 * @createdate 2019/8/13 20:17
 */
@Data
public class ProdCommListVo implements Serializable
{
    private static final long serialVersionUID = 9063926645648132448L;
    /**
     *@Description //TODO   评论的数据
     *@Param
     *@Return 
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date recTime;
    /**
     *@Description //TODO   用户的头像和用户的昵称
     *@Param
     *@Return
     */
    private String userId;
    private String pic;
    private String nickName;
    /**
     *@Description //TODO   评论相关的
     *@Param
     *@Return
     */
    private Integer score;
    /**
     *@Description //TODO   评论
     *@Param
     *@Return
     */
    private String content;
    /**
     *@Description //TODO  图片
     *@Param
     *@Return
     */
    private String pics;
}

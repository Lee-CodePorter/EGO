package top.leesh.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author 李书涵 商品评论扩展类
 * @package_name: top.leesh.vo
 * @createdate 2019/8/13 19:23
 */
@Data
public class ProdCommVo implements Serializable
{


    private static final long serialVersionUID = -7725332816621130307L;
    /**
     * 好评率
     */
    private BigDecimal positiveRating;
    /**
     * 评论的总条数
     */
    private long number;
    /**
     * 好评数
     */
    private long praiseNumber;
    /**
     * 中评
     */
    private long secondaryNumber;
    /**
     * 差评
     */
    private long negativeNumber;
    /**
     * 有图
     */
    private long picNumber;
}

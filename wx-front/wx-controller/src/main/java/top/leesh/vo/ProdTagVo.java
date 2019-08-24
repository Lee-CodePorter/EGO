package top.leesh.vo;

import lombok.Data;

import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.vo
 * @createdate 2019/8/8 14:31
 */
@Data
public class ProdTagVo
{
    /**
     * 标签的id
     */
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 风格或样式
     */
    private Integer style;

    /**
     * 对应tag的商品
     */
    private List<ProdVo> prods;
}

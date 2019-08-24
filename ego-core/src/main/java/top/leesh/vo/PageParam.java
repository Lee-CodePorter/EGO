package top.leesh.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.vo
 * @createdate 2019/8/13 20:36
 */
@Data
public class PageParam<T> implements Serializable
{
    private static final long serialVersionUID = -6332362315146235889L;

    /**
     * 当前也
     */
    private long current;
    /**
     * 显示的大小
     */
    private long size;
    /**
     * 总条数
     */
    private long pages;
    /**
     * 数据
     */
    private List<T> records;
}

package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.ProdTag;

import java.util.List;

/**
 * <p>
 * 商品分组表 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface IProdTagService extends IService<ProdTag> {

    /**
     *@Description //TODO      获取商品分组信息
     *@Param [page, tag]
     *@Return com.baomidou.mybatisplus.core.metadata.IPage<top.leesh.pojo.ProdTag>
     */
    IPage<ProdTag> getPage(Page<ProdTag> page, ProdTag tag);

    List<ProdTag> getTagList();

}

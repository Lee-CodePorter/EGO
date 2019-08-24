package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.Category;
import top.leesh.pojo.WeChatProdVo;

import java.util.List;

/**
 * <p>
 * 产品类目 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface ICategoryService extends IService<Category> {

    /**
     *@Description //TODO      查询商品分类分集合
     *@Param [parentId]
     *@Return java.util.List<top.leesh.pojo.Category>
     */
    List<Category> getCateGoryList(String parentId);

    List<WeChatProdVo> getProdListByParId(Long categoryId);
}

package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.ProdProp;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface IProdPropService extends IService<ProdProp>
{
    /**
     * 商品规格
     * @param prodPropPage
     * @param page
     * @return
     */
    IPage<ProdProp> getPage(Page<ProdProp> prodPropPage, ProdProp page);

    Boolean updateValue(ProdProp prodProp);
}
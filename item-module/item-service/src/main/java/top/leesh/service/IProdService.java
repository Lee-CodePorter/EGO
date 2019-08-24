package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.Prod;
import top.leesh.pojo.ProdProp;

import java.util.List;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface IProdService extends IService<Prod> {

    IPage<Prod> getPage(Page<Prod> page, Prod prod);

    Boolean saveProdVlue(ProdProp prodProp);


    List<Prod> getProdSolrVoList();

    Prod getProdAndSkuById(Long prodId);
}

package top.leesh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import top.leesh.mapper.ProdFavoriteMapper;
import top.leesh.pojo.ProdFavorite;
import top.leesh.service.IProdFavoriteService;

/**
 * <p>
 * 商品收藏表 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class ProdFavoriteServiceImpl extends ServiceImpl<ProdFavoriteMapper, ProdFavorite> implements IProdFavoriteService {

}

package top.leesh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.leesh.mapper.SkuMapper;
import top.leesh.pojo.Sku;
import top.leesh.service.ISkuService;

/**
 * <p>
 * 单品SKU表 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class SkuServiceImpl extends ServiceImpl<SkuMapper, Sku> implements ISkuService {

}

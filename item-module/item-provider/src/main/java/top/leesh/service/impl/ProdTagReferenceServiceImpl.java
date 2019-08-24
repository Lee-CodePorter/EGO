package top.leesh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import top.leesh.mapper.ProdTagReferenceMapper;
import top.leesh.pojo.ProdTagReference;
import top.leesh.service.IProdTagReferenceService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class ProdTagReferenceServiceImpl extends ServiceImpl<ProdTagReferenceMapper, ProdTagReference> implements IProdTagReferenceService {

}

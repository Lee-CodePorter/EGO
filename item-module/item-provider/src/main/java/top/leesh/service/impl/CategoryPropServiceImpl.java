package top.leesh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import top.leesh.mapper.CategoryPropMapper;
import top.leesh.pojo.CategoryProp;
import top.leesh.service.ICategoryPropService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class CategoryPropServiceImpl extends ServiceImpl<CategoryPropMapper, CategoryProp> implements ICategoryPropService {

}

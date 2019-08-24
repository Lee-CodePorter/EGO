package top.leesh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import top.leesh.mapper.CategoryBrandMapper;
import top.leesh.pojo.CategoryBrand;
import top.leesh.service.ICategoryBrandService;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class CategoryBrandServiceImpl extends ServiceImpl<CategoryBrandMapper, CategoryBrand> implements ICategoryBrandService {

}

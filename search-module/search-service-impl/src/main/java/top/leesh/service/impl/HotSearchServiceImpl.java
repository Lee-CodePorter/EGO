package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.leesh.mapper.HotSearchMapper;
import top.leesh.pojo.HotSearch;
import top.leesh.service.IHotSearchService;

/**
 * <p>
 * 热搜 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class HotSearchServiceImpl extends ServiceImpl<HotSearchMapper, HotSearch> implements IHotSearchService {

}

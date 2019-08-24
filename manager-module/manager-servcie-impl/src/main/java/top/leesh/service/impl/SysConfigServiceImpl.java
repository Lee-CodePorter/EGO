package top.leesh.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.leesh.mapper.SysConfigMapper;
import top.leesh.pojo.SysConfig;
import top.leesh.service.ISysConfigService;

/**
 * <p>
 * 系统配置信息表 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements ISysConfigService {

}

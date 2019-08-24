package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import top.leesh.mapper.SysLogMapper;
import top.leesh.pojo.SysLog;
import top.leesh.service.ISysLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService {

}

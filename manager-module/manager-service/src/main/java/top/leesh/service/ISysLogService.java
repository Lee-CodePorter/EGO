package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.SysLog;

/**
 * <p>
 * 系统日志 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface ISysLogService extends IService<SysLog> {

    IPage<SysLog> getAllLogs(Page<SysLog> page, SysLog log);
}

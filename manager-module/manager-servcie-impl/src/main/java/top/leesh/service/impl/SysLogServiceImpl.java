package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import top.leesh.mapper.SysLogMapper;
import top.leesh.pojo.SysLog;
import top.leesh.service.ISysLogService;

/**
 * <p>
 * 系统日志 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLog> implements ISysLogService
{
    @Autowired
    private SysLogMapper logMapper;

    @Override
    public IPage<SysLog> getAllLogs(Page<SysLog> page, SysLog log)
    {
        //创建条件对象
        QueryWrapper<SysLog> wrapper = new QueryWrapper<>();
        wrapper.like(StringUtils.hasText(log.getUsername()),"username",log.getUsername());
        wrapper.like(StringUtils.hasText(log.getOperation()),"operation",log.getOperation());
        return logMapper.selectPage(page, wrapper);
    }
}

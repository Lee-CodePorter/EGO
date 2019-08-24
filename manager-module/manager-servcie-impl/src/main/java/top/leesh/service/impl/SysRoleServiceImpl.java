package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.leesh.mapper.SysRoleMapper;
import top.leesh.pojo.SysRole;
import top.leesh.service.ISysRoleService;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService
{

    @Autowired
    private SysRoleMapper roleMapper;



    @Override
    public IPage<SysRole> getPage(Page<SysRole> page, SysRole role)
    {
            return null;
    }
}

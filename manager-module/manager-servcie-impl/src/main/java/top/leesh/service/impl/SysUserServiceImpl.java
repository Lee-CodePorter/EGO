package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import top.leesh.mapper.SysUserMapper;
import top.leesh.mapper.SysUserRoleMapper;
import top.leesh.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.leesh.service.ISysUserService;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService
{

    @Autowired
    private  SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper roleMapper;


    //获取管理员列表
    @Override
    public IPage<SysUser> getPage(Page<SysUser> sysUserPage, SysUser user)
    {
        //创建条件对象
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>();
        queryWrapper.like(StringUtils.hasText(user.getUsername()), "username", user.getUsername());
        IPage<SysUser> UserPages = userMapper.selectPage(sysUserPage, queryWrapper);
        return UserPages;
    }
}

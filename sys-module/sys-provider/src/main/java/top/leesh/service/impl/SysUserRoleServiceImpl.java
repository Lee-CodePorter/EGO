package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.leesh.mapper.SysUserRoleMapper;
import top.leesh.pojo.SysUserRole;
import top.leesh.service.ISysUserRoleService;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

}

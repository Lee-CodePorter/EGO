package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

}

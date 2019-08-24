package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.leesh.mapper.SysUserMapper;
import top.leesh.pojo.SysUser;
import top.leesh.service.ISysUserService;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

}

package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import top.leesh.pojo.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 系统用户 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface ISysUserService extends IService<SysUser> {

    IPage<SysUser> getPage(Page<SysUser> sysUserPage, SysUser user);
}

package top.leesh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.SysRole;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface ISysRoleService extends IService<SysRole> {

    IPage<SysRole> getPage(Page<SysRole> page, SysRole role);
}

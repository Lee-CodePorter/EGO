package top.leesh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.SysMenu;
import top.leesh.vo.MenuVo;

import java.util.List;

/**
 * <p>
 * 菜单管理 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
public interface ISysMenuService extends IService<SysMenu>
{
    //加载树
    List<MenuVo> loadTreeData(Long userId);

    List<String> loadAllAuths(Long userId);
}

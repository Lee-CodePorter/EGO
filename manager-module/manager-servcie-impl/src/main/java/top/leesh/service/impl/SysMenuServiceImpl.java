package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.leesh.mapper.SysMenuMapper;
import top.leesh.pojo.SysMenu;
import top.leesh.service.ISysMenuService;
import top.leesh.vo.MenuVo;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 菜单管理 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService
{

    @Autowired
    private  SysMenuMapper mapper;

    //加载整个树
    @Override
    public List<MenuVo> loadTreeData(Long userId)
    {
        return getAllTreeData();
    }


    public List<MenuVo> getAllTreeData()
    {
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.ne("type",2);
        //加载所有的数据
        List<SysMenu> sysMenus = mapper.selectList(wrapper);
        //
        ArrayList<MenuVo> menuVos = new ArrayList<>();

        for (SysMenu sysMenu : sysMenus)
        {
            MenuVo menuVo = new MenuVo();
            BeanUtils.copyProperties(sysMenu,menuVo);
            menuVos.add(menuVo);
        }

        //创建有节点关系的集合
        ArrayList<MenuVo> list = new ArrayList<>();
        for (MenuVo menuVo : menuVos) {
            if(menuVo.getParentId()==0)
            {
                list.add(menuVo);
            }
            for (MenuVo vo : menuVos)
            {
                if(vo.getParentId()==menuVo.getMenuId())
                {
                    menuVo.getList().add(vo);
                }
            }
        }
        return  list;
    }


    @Override
    public List<String> loadAllAuths(Long userId)
    {
        QueryWrapper<SysMenu> wrapper = new QueryWrapper<>();
        wrapper.eq("type",2);
        List<SysMenu> menuList = mapper.selectList(wrapper);
        List<String> list = new ArrayList<>(menuList.size());


        for (SysMenu sysMenu : menuList)
        {
            list.add(sysMenu.getPerms());
        }
        return list;
    }




}

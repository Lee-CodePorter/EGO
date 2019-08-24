package top.leesh.vo;

import lombok.Getter;
import lombok.Setter;
import top.leesh.pojo.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.vo
 * @createdate 2019/7/31 11:17
 */
@Getter
@Setter
public class MenuVo extends SysMenu
{

    private static final long serialVersionUID = 8906619972248534650L;


    private List<MenuVo> list = new ArrayList<MenuVo>();
}

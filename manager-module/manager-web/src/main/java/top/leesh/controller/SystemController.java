package top.leesh.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.pojo.*;
import top.leesh.service.*;

import java.util.List;

/**
 * @author 李书涵 系统管理控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/5 19:34
 */
@RestController
@RequestMapping("/sys")
public class SystemController
{
    /**
     *@Description //TODO      
     *@Param 管理员 
     *@Return
     */
    @Autowired
    private ISysUserService userService;

    /**
     *@Description //TODO   角色管理
     *@Param
     *@Return
     */
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     *@Description //TODO      菜单管理
     *@Param
     *@Return
     */
    @Autowired
    private ISysMenuService menuService;
    
    
    /**
     *@Description //TODO      
     *@Param 日志
     *@Return
     */
    @Autowired
    private ISysLogService logService;
    
    
    /**
     *@Description //TODO    管理员分页查询
     *@Param [sysUserPage, user]
     *@Return java.lang.Object
     */
    @GetMapping("/user/page")
    public ResponseEntity<IPage<SysUser>> getAdminList(Page<SysUser> sysUserPage, SysUser user)
    {
        return  ResponseEntity.ok(userService.getPage(sysUserPage,user)) ;
    }

    /**
     *@Description //TODO   修改管理员回显
     *@Param []
     *@Return org.springframework.http.ResponseEntity<java.util.List<top.leesh.pojo.SysUser>>
     */
    @GetMapping("/role/list")
    public  ResponseEntity<List<SysUser>> getAdmin()
    {
        return ResponseEntity.ok(userService.list());
    }


    
    /**
     *@Description //TODO      角色分页查询
     *@Param [page, role]
     *@Return org.springframework.http.ResponseEntity<com.baomidou.mybatisplus.core.metadata.IPage<top.leesh.pojo.SysRole>>
     */
    @GetMapping("/role/page")
    public ResponseEntity<IPage<SysRole>> getRoleUser(Page<SysRole> page,SysRole role)
    {
        return ResponseEntity.ok(sysRoleService.getPage(page,role));
    }


    /**
     *@Description //TODO      菜单全查询(只需全查询,前端已经做好)
     *@Param []
     *@Return org.springframework.http.ResponseEntity<java.util.List<top.leesh.pojo.SysMenu>>
     */
    @GetMapping("/menu/table")
    public  ResponseEntity<List<SysMenu>> getMenu()
    {
        return ResponseEntity.ok(menuService.list());
    }


    /**
     *@Description //TODO      获得操作日志
     *@Param [page, log]
     *@Return org.springframework.http.ResponseEntity<com.baomidou.mybatisplus.extension.plugins.pagination.Page<top.leesh.pojo.SysLog>>
     */
    @GetMapping("/log/page")
    public  ResponseEntity<IPage<SysLog>> getOpLog(Page<SysLog> page,SysLog log)
    {
        return ResponseEntity.ok(logService.getAllLogs(page,log));
    }

}

package top.leesh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.pojo.Area;
import top.leesh.service.IAreaService;

import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.controller
 * @createdate 2019/8/5 21:46
 */
@RestController
@RequestMapping("/admin")
public class AreaController
{

    @Reference
    private IAreaService areaService;


    /**
     *@Description //TODO    地址管理
     *@Param [area]
     *@Return org.springframework.http.ResponseEntity<java.util.List<top.leesh.pojo.Area>>
     */
    @GetMapping("/area/list")
    public ResponseEntity<List<Area>> getAddress(Area area)
    {
        System.out.println("地址管理");
        return  ResponseEntity.ok(areaService.listAres(area));
    }

}

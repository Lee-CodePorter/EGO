package top.leesh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.service.INoticeService;
import top.leesh.vo.NoticeVo;

import java.util.List;

/**
 * @author 李书涵 公告控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/8 10:22
 */
@RestController
public class NoticeController
{
    @Reference
    private INoticeService service;

    /**
     *@Description //TODO      
     *@Param 转换类
     *@Return
     */
    @Autowired
    private MapperFacade mapperFacade;


    /**
     *@Description //TODO      加载公告
     *@Param []
     *@Return org.springframework.http.ResponseEntity<java.util.List<top.leesh.vo.NoticeVo>>
     */
    @GetMapping("/shop/notice/topNoticeList")
    public ResponseEntity<List<NoticeVo>> getNoticList()
    {
        return  ResponseEntity.ok(mapperFacade.mapAsList(service.getNoticeList(),NoticeVo.class));
    }


}

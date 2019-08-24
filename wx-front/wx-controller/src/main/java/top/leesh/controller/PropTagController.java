package top.leesh.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.pojo.ProdTag;
import top.leesh.service.IProdTagService;
import top.leesh.vo.ProdTagVo;

import java.util.List;

/**
 * @author 李书涵
 * @package_name: top.leesh.controller
 * @createdate 2019/8/8 14:15
 */
@RestController
public class PropTagController
{

    @Reference
    private IProdTagService tagService;

    @Autowired
    private MapperFacade mapperFacade;


    @GetMapping("/prod/tag/prodTagList")
    private ResponseEntity<List<ProdTagVo>> getProdTag()
    {
        List<ProdTag> tagList = tagService.getTagList();
        return ResponseEntity.ok(mapperFacade.mapAsList(tagList, ProdTagVo.class)) ;
    }

}

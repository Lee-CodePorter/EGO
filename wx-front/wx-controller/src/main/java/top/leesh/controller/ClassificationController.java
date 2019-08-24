package top.leesh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.pojo.Category;
import top.leesh.pojo.WeChatProdVo;
import top.leesh.service.ICategoryService;
import top.leesh.vo.CateGoryVo;
import java.util.List;

/**
 * @author 李书涵 商品类别前端控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/12 19:31
 */
@RestController
public class ClassificationController
{

    @Reference
    private ICategoryService categoryService;


    @Autowired
    private MapperFacade mapperFacade;


    /**
     *@Description //TODO    获取商品分类集合
     *@Param [parentId]
     *@Return org.springframework.http.ResponseEntity<java.util.List<top.leesh.vo.CateGoryVo>>
     */
    @GetMapping("/category/categoryInfo")
    public ResponseEntity<List<CateGoryVo>> getClassification(String parentId)
    {
        List<Category> goryList = categoryService.getCateGoryList(parentId);
        List<CateGoryVo> voList = mapperFacade.mapAsList(goryList, CateGoryVo.class);
        return  ResponseEntity.ok(voList);
    }

    /**
     *@Description //TODO      查询商品分类
     *@Param [categoryId]
     *@Return org.springframework.http.ResponseEntity<java.util.List<top.leesh.pojo.WeChatProdVo>>
     */
    @GetMapping("/prod/pageProd")
    public ResponseEntity<List<WeChatProdVo>> getCateGoryById(Long categoryId)
    {
       return ResponseEntity.ok(categoryService.getProdListByParId(categoryId));
    }
}

package top.leesh.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.*;
import top.leesh.pojo.*;
import top.leesh.service.*;
import top.leesh.sms.SMS;

/**
 * <p>
 * 商品 前端控制器
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@RestController
@RequestMapping("/prod")
public class ProdController
{
    /**
     *@Description //TODO 产品服务
     *@Param
     *@return
     */
    @Reference
    private IProdService prodService;

    /**
     *@Description //TODO 规格管理
     *@Param
     *@return
     */
    @Reference
    private IProdPropService prodPropService;

    /**
     *@Description //TODO 规格值
     *@Param
     *@Return
     */
    @Reference
    private  IProdPropValueService prodPropValueService;



    /**
     *@Description //TODO 商品评论
     *@Param
     *@Return 
     */
    @Reference
    private IProdCommService commService;

    /**
     *@Description //TODO 分类管理
     *@Param
     *@Return
     */
    @Reference
    private ICategoryService categoryService;

    /**
     *@Description //TODO 分组管理
     *@Param
     *@Return
     */
    @Reference
    private IProdTagService tagService;


    @GetMapping("/pro/{id}")
    @ResponseBody
    public Prod getpro(@PathVariable("id") String id)
    {
        System.out.println(id);
        Prod byId = prodService.getById(id);
        System.out.println(byId);
        return byId;
    }

    /**
     *@Description //TODO 加载所有商品数据
     *@Param [page, prod]
     *@return java.lang.Object
     */
    @GetMapping("/prod/page")
    public <T> Object getpropList(Page<Prod> page, Prod prod)
    {
        return prodService.getPage(page,prod);
    }

    /**
     *@Description //TODO 规格管理
     *@Param [prodPropPage, Page] 
     *@return java.lang.Object
     */
    @GetMapping("/spec/page")
    public  Object getSpecification(Page<ProdProp> prodPropPage,ProdProp Page)
    {
        return  prodPropService.getPage(prodPropPage,Page);
    }

    /**
     *@Description //TODO 规格新增
     *@Param [prodProp]
     *@Return java.lang.Object
     */
    @PostMapping("/spec")
    public Object addSpec(@RequestBody ProdProp prodProp)
    {
        System.out.println("进入规格新增");
        //获得当前用户
        SysUser user = (SysUser)SecurityUtils.getSubject().getPrincipal();
        prodProp.setShopId(user.getShopId());
        prodProp.setRule(1);
        return  prodService.saveProdVlue(prodProp);
    }

    /**
     *@Description //TODO 更新规格
     *@Param [prodProp]
     *@Return java.lang.Object
     */
    @PutMapping("/spec")
    public  Object updateSpec(@RequestBody ProdProp prodProp)
    {
        System.out.println("进入规格修改");
        System.out.println(prodProp);
        System.out.println(prodProp.getPropId());
        return  prodPropService.updateValue(prodProp);
    }

    /**
     *@Description //TODO   删除规格
     *@Param [args]
     *@Return java.lang.Object
     */
    @DeleteMapping("/spec/{id}")
    public Object deleteSpec(@PathVariable("id") String []args)
    {
        try {
            //删除规格属性
            prodPropService.removeById(args[0]);
            //删除规格值
            prodPropValueService.removeById(args[0]);
            return  true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    /**
     *@Description //TODO  商品评论
     *@Param [commPage, comm]
     *@Return java.lang.Object
     */
    @GetMapping("/prodComm/page")
    public  Object getComment(Page<ProdComm> commPage,ProdComm comm)
    {
        return  commService.getPage(commPage,comm);
    }

    /**
     *@Description //TODO 分类管理
     *@Param [page, category]
     *@Return java.lang.Object
     */
    @GetMapping("/category/table")
    public  Object getClassification(Page<Category> page,Category category)
    {
        return categoryService.list();
    }


    /**
     *@Description //TODO 分组管理
     *@Param [page, tag]
     *@Return java.lang.Object
     */
    @GetMapping("/prodTag/page")
    public  Object getprodTag(Page<ProdTag> page,ProdTag tag)
    {
        return tagService.getPage(page,tag);
    }


//    public static void main(String[] args)
//    {
//        int message = SMS.sendMessage("15071954407", "1234", "10");
//        System.out.println(message);
//
//    }

}

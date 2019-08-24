package top.leesh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.pojo.Prod;
import top.leesh.pojo.ProdComm;
import top.leesh.service.IProdCommService;
import top.leesh.service.IProdService;
import top.leesh.vo.PageParam;
import top.leesh.vo.ProdCommListVo;
import top.leesh.vo.ProdCommVo;
import top.leesh.vo.ProdVo;

import java.util.List;

/**
 * @author 李书涵  商品前端控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/12 21:51
 */
@RestController
public class ProdController
{

    @Reference
    private IProdService prodService;


    @Reference
    private IProdCommService commService;

    @Autowired
    private MapperFacade mapperFacade;


    /**
     *@Description //TODO 商品详情页(获取商品详情包括sku)
     *@Param [prodId]
     *@Return org.springframework.http.ResponseEntity<java.lang.Object>
     */
    @GetMapping("/prod/prodInfo")
    public ResponseEntity<Object> getProdInfo(Long prodId)
    {
        Prod prod = prodService.getProdAndSkuById(prodId);
        ProdVo prodVo = mapperFacade.map(prod, ProdVo.class);
        return  ResponseEntity.ok(prodVo);
    }

    /**
     *@Description //TODO    获取商品的评论
     *@Param [prodId]
     *@Return org.springframework.http.ResponseEntity<java.util.List<top.leesh.vo.ProdCommVo>>
     */
    @GetMapping("/prodComm/prodCommData")
    public  ResponseEntity<ProdCommVo> getProdComm(Integer prodId)
    {
       return ResponseEntity.ok(commService.getProdCommById(prodId)) ;
    }


    /**
     *@Description //TODO   查询评论
     *@Param [page, prodId, evaluate]
     *@Return org.springframework.http.ResponseEntity<top.leesh.vo.PageParam<top.leesh.vo.ProdCommListVo>>
     */
    @GetMapping("/prodComm/prodCommPageByProd")
    public  ResponseEntity<PageParam<ProdCommListVo>> getProdCommList(Page<ProdComm> page,Integer prodId, Integer evaluate)
    {
        return ResponseEntity.ok(commService.getProdCommList(page,prodId,evaluate)) ;
    }


//    @PostMapping("/p/shopCart/changeItem")
//    public ResponseEntity<Object> addProdToCart()

}

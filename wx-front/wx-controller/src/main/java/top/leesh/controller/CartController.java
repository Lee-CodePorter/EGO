package top.leesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.vo.ItemVo;

import javax.servlet.http.HttpSession;

/**
 * @author 李书涵  购物车前端控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/15 14:40
 */
@RestController
public class CartController
{

    @Autowired
    private HttpSession session;


    @PostMapping("/p/shopCart/changeItem")
    public ResponseEntity<Object> addProdToCart(@RequestBody ItemVo itemVo)
    {

        System.out.println(itemVo.toString());
        return  null;
    }


}

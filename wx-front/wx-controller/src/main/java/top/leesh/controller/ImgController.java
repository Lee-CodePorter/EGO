package top.leesh.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.leesh.pojo.IndexImg;
import top.leesh.service.IIndexImgService;
import top.leesh.vo.IndexImgVo;

import java.util.List;

/**
 * @author 李书涵 轮播图控制器
 * @package_name: top.leesh.controller
 * @createdate 2019/8/7 8:56
 */
@RestController
public class ImgController
{

    @Reference
    private IIndexImgService indexImgService;


    @Autowired
    private MapperFacade mapperFacade;


    @GetMapping("/indexImgs")
    public ResponseEntity<List<IndexImgVo>> getImg()
    {
        List<IndexImg> imgList = indexImgService.getIndexImgList();
        List<IndexImgVo> imgVoList = mapperFacade.mapAsList(imgList, IndexImgVo.class);
        return  ResponseEntity.ok(imgVoList);
    }

}

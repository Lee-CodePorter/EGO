package top.leesh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.IndexImg;

import java.util.List;

/**
 * <p>
 * 主页轮播图 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
public interface IIndexImgService extends IService<IndexImg>
{
   /**
    *@Description //TODO 查询首页轮播图集合
    *@Param []
    *@Return java.util.List<top.leesh.pojo.IndexImg>
    */

    List<IndexImg> getIndexImgList();


}

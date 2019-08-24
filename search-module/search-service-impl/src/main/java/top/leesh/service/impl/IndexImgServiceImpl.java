package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.leesh.anno.EnableCache;
import top.leesh.mapper.IndexImgMapper;
import top.leesh.pojo.IndexImg;
import top.leesh.service.IIndexImgService;

import java.util.List;

/**
 * <p>
 * 主页轮播图 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class IndexImgServiceImpl extends ServiceImpl<IndexImgMapper, IndexImg> implements IIndexImgService
{
    @Autowired
    private  IndexImgMapper indexImgMapper;
    /**
     *@Description //TODO 查询首页轮播图集合
     *@Param []
     *@Return java.util.List<top.leesh.pojo.IndexImg>
     */
    @EnableCache(key = "index_img",userEL = false,returnClass = IndexImg.class)
    @Override
    public List<IndexImg> getIndexImgList()
    {
        QueryWrapper<IndexImg> wrapper = new QueryWrapper<>();

        wrapper.eq("status",1).orderByAsc("seq");

        return indexImgMapper.selectList(wrapper);
    }
}

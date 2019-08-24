package top.leesh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import top.leesh.mapper.ProdTagMapper;
import top.leesh.pojo.Prod;
import top.leesh.pojo.ProdTag;
import top.leesh.service.IProdTagService;

import java.util.List;

/**
 * <p>
 * 商品分组表 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-07-28
 */
@Service
public class ProdTagServiceImpl extends ServiceImpl<ProdTagMapper, ProdTag> implements IProdTagService
{
    @Autowired
    private  ProdTagMapper tagMapper;

    @Override
    public IPage<ProdTag> getPage(Page<ProdTag> page, ProdTag tag)
    {
        //创建条件对象
        QueryWrapper<ProdTag> wrapper = new QueryWrapper<>();
        //模糊查询
        wrapper.like(StringUtils.hasText(tag.getTitle()),"title",tag.getTitle());

        return tagMapper.selectPage(page, wrapper);
    }

    @Override
    public List<ProdTag> getTagList()
    {
        return tagMapper.selectList(new LambdaQueryWrapper<ProdTag>().orderByDesc(ProdTag::getSeq));
    }
}

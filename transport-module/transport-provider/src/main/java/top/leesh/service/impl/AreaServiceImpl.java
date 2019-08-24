package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import top.leesh.mapper.AreaMapper;
import top.leesh.pojo.Area;
import top.leesh.service.IAreaService;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class AreaServiceImpl extends ServiceImpl<AreaMapper, Area> implements IAreaService
{
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public List<Area> listAres(Area area)
    {
        QueryWrapper<Area> wrapper = new QueryWrapper<Area>();

//        wrapper.like(StringUtils.hasText(area.getAreaName()),new Area().getAreaName(),area.getAreaName());
      wrapper.lambda().like(StringUtils.hasText(area.getAreaName()), Area::getAreaName, area.getAreaName());
        return areaMapper.selectList(wrapper);
    }
}

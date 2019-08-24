package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.leesh.mapper.NoticeMapper;
import top.leesh.pojo.Notice;
import top.leesh.service.INoticeService;

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
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService
{
    @Autowired
    private  NoticeMapper noticeMapper;


    /**
     *@Description //TODO      加载公告
     *@Param []
     *@Return java.util.List<top.leesh.pojo.Notice>
     */
    @Override
    public List<Notice> getNoticeList()
    {
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.select("title");
        return noticeMapper.selectList(wrapper);
    }
}

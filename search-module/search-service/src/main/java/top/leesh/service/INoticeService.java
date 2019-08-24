package top.leesh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.Notice;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
public interface INoticeService extends IService<Notice> {

    /**
     *@Description //TODO      加载公告
     *@Param []
     *@Return java.util.List<top.leesh.pojo.Notice>
     */
    List<Notice> getNoticeList();

}

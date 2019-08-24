package top.leesh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.Area;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
public interface IAreaService extends IService<Area> {

    List<Area> listAres(Area area);

}

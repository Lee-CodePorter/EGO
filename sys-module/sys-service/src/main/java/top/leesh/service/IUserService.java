package top.leesh.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.leesh.pojo.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
public interface IUserService extends IService<User> {

    User findUserByOpenid(String openId);

}

package top.leesh.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import top.leesh.mapper.UserMapper;
import top.leesh.pojo.User;
import top.leesh.service.IUserService;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author 李书涵
 * @since 2019-08-05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService
{
    @Autowired
    private  UserMapper userMapper;


    @Override
    public User findUserByOpenid(String openId)
    {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",openId);
        return  userMapper.selectOne(wrapper);
    }
}

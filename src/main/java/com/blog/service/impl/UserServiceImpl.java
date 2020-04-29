package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.ResultBean;
import com.blog.bean.User;
import com.blog.mapper.UserMapper;
import com.blog.service.UserService;
import com.blog.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    @Qualifier(value = "resultBean")
    ResultBean rb;

    @Override
    @Transactional
    public ResultBean register(User user) {
        //1表示普通用户
        user.setUserType(1);
        String email = user.getEmail();
        Boolean b = findUserByEmail(email);
        if (b) {
            return rb.fail("邮箱被注册");
        }
        int i = baseMapper.insert(user);
        if (ResultUtils.result(i)) {
            return rb.success("注册成功");
        } else {
            return rb.fail("注册失败");
        }
    }


        /**
         * @discription 邮箱是否被注册
         * @param email 邮箱
         * @return  true 邮箱被注册 false 邮箱未被注册
         * @version V1.0
         */
    @Override
    public Boolean findUserByEmail(String email) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("email", email);
        User user = baseMapper.selectOne(qw);
        return ResultUtils.result(user);
    }

    @Override
    public ResultBean login(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        String email = user.getEmail();
        String pass = user.getPass();
        qw.eq("email", email);
        qw.eq("pass", pass);
        User user1 = baseMapper.selectOne(qw);
        if (!ResultUtils.result(user1)) {
            return rb.fail("用户不存在!或者账号密码不匹配");
        } else {
            ResultBean success = rb.success("登陆成功");
            success.setData(user1);
            return success;
        }
    }
}

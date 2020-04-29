package com.blog.service;

import com.blog.bean.ResultBean;
import com.blog.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
public interface UserService extends IService<User> {


        /**
         * @discription 用户注册的方法
         * @param user 用户bean
         * @return  结果bean
         * @version V1.0
         */
    ResultBean register(User user);


        /**
         * @discription 验证邮箱是否被注册
         * @param email 邮箱
         * @return  boolean 邮箱是否被注册
         * @version V1.0
         */
    Boolean findUserByEmail(String email);

    /**
     * @param user 用户bean
     * @return 用户数据的结果
     * @discription 验证用户的账号和密码
     * @version V1.0
     */
    ResultBean login(User user);
}

package com.blog.controller;

import com.blog.bean.ResultBean;
import com.blog.bean.User;
import com.blog.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
@RestController
@RequestMapping("/blog/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ResultBean rb;

    @ApiOperation("修改个人信息")
    @PutMapping("/updateUser")
    public ResultBean updateUser(User user) {
        System.out.println(user);
        boolean b = userService.updateById(user);
        if (b) {
            return rb.success("修改成功");
        } else {
            return rb.fail("修改失败");
        }
    }
}


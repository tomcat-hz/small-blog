package com.blog.controller;

import com.blog.bean.ResultBean;
import com.blog.bean.User;
import com.blog.service.UserService;
import com.blog.util.ResultUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/27 15:17
 */
@RestController
public class LoginController {

    @Autowired
    @Qualifier(value = "resultBean")
    ResultBean rb;
    @Autowired
    UserService userService;


    @ApiOperation("注册个人账号")
    @PostMapping("/register")
    public ResultBean register(User user) {
        return userService.register(user);
    }

    @ApiOperation("登陆个人账户")
    @PostMapping("/user/login")
    public ResultBean login(User user, HttpSession session) {
        System.out.println(user);
        ResultBean rb = userService.login(user);
        Object data = rb.getData();
        if (data != null) {
            user = (User) data;
            session.setAttribute("user", user);
        }
        return rb;
    }

    @ApiOperation("退出登陆")
    @GetMapping("/logout")
    public ModelAndView logout(HttpSession session, ModelAndView mv) {
        Object o = session.getAttribute("user");
        if (ResultUtils.result(o)) {
            session.setAttribute("user", null);
            mv.addObject("msg", "退出成功");
        }
        mv.setViewName("index");
        return mv;
    }
}

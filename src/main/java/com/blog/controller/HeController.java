package com.blog.controller;

import com.blog.bean.ResultBean;
import com.blog.service.BlogService;
import com.blog.util.HtmlParse;
import com.blog.util.RandomNumber;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/16 12:32
 */
@Controller
public class HeController {

    @Autowired
    private HtmlParse htmlParse;

    @Autowired
    BlogService blogService;

    @Autowired
    JavaMailSenderImpl mailSender;
    @Autowired
    ResultBean rb;


    @GetMapping("/baidu")
    @ResponseBody
    public String baidu(String keyword) {
        String pwd = htmlParse.pwd(keyword);
        return pwd == null || pwd.equals("") ? "没有找到答案" : pwd+"--声明:来自百度百科";
    }

    @GetMapping("/translate")
    @ResponseBody
    public String translate(String keyword) {
        String pwd = htmlParse.translate(keyword);
        return pwd == null || pwd.equals("") ? "没有找到答案" : pwd+"--声明:来自有道翻译";
    }

    //主界面的内容
    @GetMapping("/pageBlog")
    @ResponseBody
    public ResultBean index(Model model, @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "4") Integer limit, String title,Integer typeId,Integer original) { System.out.println(title+"999");
        ResultBean rb = blogService.page(page, limit,title,typeId,original);
        return rb;
    }


    @ApiOperation("发送邮箱")
    @GetMapping("/sendEmail")
    @ResponseBody
    public ResultBean testEmail(String email) throws InterruptedException {
        String code = RandomNumber.getCode(6);
        //邮件设置1：一个简单的邮件
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("邮箱验证");
        message.setText(code);
        message.setTo(email);
        message.setFrom("2218359849@qq.com");
        mailSender.send(message);
        ResultBean success = rb.success(code);
        return success;
    }
}

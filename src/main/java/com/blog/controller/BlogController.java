package com.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.blog.bean.Blog;
import com.blog.bean.ResultBean;
import com.blog.service.BlogService;
import com.blog.util.MarkdownUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
@Controller
@RequestMapping("/blog/blog")
public class BlogController {

    @Autowired
    BlogService blogService;

    @Autowired
    ResultBean rb;

    /**
     * @param page 当前页 limit每页显示数目
     * @return 类型的分页
     * @discription
     * @version V1.0
     */
    @GetMapping("/admin/blogPage")
    @ResponseBody
    public ResultBean blogPage(Integer page, Integer limit, String title, Integer typeId, Integer original) {
        return blogService.page(page, limit, title,typeId,original);
    }


    @PostMapping("/admin/saveBlog")
    @ResponseBody
    public ResultBean saveBlog(Blog blog) {
        boolean b = blogService.save(blog);
        if (b) {
            return rb.success("保存成功");
        } else {
            return rb.fail("保存失败");
        }
    }

    @GetMapping("/count")
    @ResponseBody
    public Integer count(String title, Integer typeId, Integer original) {
        QueryWrapper<Blog> qw = null;
        if (!StringUtils.isEmpty(title)) {
            qw = new QueryWrapper<>();
            qw.like("title", title);
        }
        if (typeId != null) {
            qw.eq("typeId", typeId);
        }
        if (original != null) {
            qw.eq("original", original);
        }
        return blogService.count(qw);
    }

    @GetMapping("/content/{id}")
    public ModelAndView getContent(@PathVariable(value = "id") Integer id, ModelAndView mv) {
        Blog blog = blogService.getById(id);
        if (blog != null) {
            String content = blog.getContent();
            content = MarkdownUtils.markdownToHtmlExtensions(content);
            blog.setContent(content);
            mv.addObject("blog", blog);
            mv.setViewName("content");
        } else {
            mv.addObject("msg", "没有这篇博客");
            mv.setViewName("index");
        }
        return mv;
    }

    @DeleteMapping("/deleteBlog/{id}")
    @ResponseBody
    public String deleteBlog(@PathVariable(value = "id") Integer id) {
        boolean b = blogService.removeById(id);
        return b ? "删除成功" : "删除失败";
    }



}


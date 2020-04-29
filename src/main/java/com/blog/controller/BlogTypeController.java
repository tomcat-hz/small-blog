package com.blog.controller;

import com.blog.bean.BlogType;
import com.blog.bean.ResultBean;
import com.blog.service.BlogTypeService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
@RestController
@RequestMapping("/blog/blog-type")
public class BlogTypeController {
    @Autowired
    ResultBean rb;

    @Autowired
    BlogTypeService blogTypeService;

    /**
     * @param page当前页 limit每页显示数目
     * @return 类型的分页
     * @discription
     * @version V1.0
     */
    @GetMapping("/admin/typePage")
    public ResultBean typePage(Integer page,Integer limit) {
        return blogTypeService.page(page, limit);
    }

    @DeleteMapping("/admin/delete/{id}")
    public String deleteType(@PathVariable(value = "id") Integer id) {
        boolean b = blogTypeService.removeById(id);
        if (b) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @PutMapping("/admin/update")
    public String updateType(BlogType blogType) {
        return blogTypeService.updateBlogType(blogType);
    }

    @PostMapping("/admin/save/{typeName}")
    public String updateType(@PathVariable(value = "typeName") String typeName) {
        BlogType blogType = new BlogType();
        blogType.setTypeName(typeName);
        boolean b = blogTypeService.save(blogType);
        if (b) {
            return "添加成功";
        } else {
            return "添加失败";
        }
    }

    @GetMapping("/admin/getAllType")
    public ResultBean getAllType() {
        List<BlogType> list = blogTypeService.list(null);
        ResultBean success = rb.success(list);
        return success;
    }

}


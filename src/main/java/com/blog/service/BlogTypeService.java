package com.blog.service;

import com.blog.bean.BlogType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.bean.ResultBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
public interface BlogTypeService extends IService<BlogType> {

    //分页显示数据
    ResultBean page(Integer page, Integer limit);

    //通过id修改数据
    String updateBlogType(BlogType blogType);

}

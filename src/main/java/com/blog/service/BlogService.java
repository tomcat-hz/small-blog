package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.bean.Blog;
import com.blog.bean.ResultBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
public interface BlogService extends IService<Blog> {

    //分页显示数据
    ResultBean page(Integer page, Integer limit,String title,Integer typeId,Integer original);


}

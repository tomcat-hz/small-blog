package com.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.Blog;
import com.blog.bean.ResultBean;
import com.blog.mapper.BlogMapper;
import com.blog.service.BlogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    ResultBean rb;

    @Override
    public ResultBean page(Integer page, Integer limit,String title,Integer typeId,Integer original) {
        IPage<Blog> ipage = new Page<>(page, limit);
        ((Page<Blog>) ipage).setDesc("id");
        QueryWrapper<Blog> qw =new QueryWrapper<>();
        if (!StringUtils.isEmpty(title)) {
            qw.like("title", title);
        }
        if (typeId != null) {
            qw.eq("type_id", typeId);
        }
        if (original != null) {
            qw.eq("original", original);
        }
        IPage<Blog> blogIPage = baseMapper.selectPage(ipage, qw);
        ResultBean success = rb.success(blogIPage.getRecords(), blogIPage.getTotal());
        return success;
    }

}

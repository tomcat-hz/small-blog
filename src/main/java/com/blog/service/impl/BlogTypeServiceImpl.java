package com.blog.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.bean.BlogType;
import com.blog.bean.ResultBean;
import com.blog.mapper.BlogTypeMapper;
import com.blog.service.BlogTypeService;
import com.blog.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
@Service
public class BlogTypeServiceImpl extends ServiceImpl<BlogTypeMapper, BlogType> implements BlogTypeService {

    @Autowired
    ResultBean rb;

    @Override
    public ResultBean page(Integer page, Integer limit) {
        IPage<BlogType> ipage = new Page<>(page, limit);
        IPage<BlogType> blogTypeIPage = baseMapper.selectPage(ipage, null);
        ResultBean success = rb.success(blogTypeIPage.getRecords(), blogTypeIPage.getTotal());
        return success;
    }


    @Override
    public String updateBlogType(BlogType blogType) {
        blogType.setUpdateTime(new Date());
        int i = baseMapper.updateById(blogType);
        if (ResultUtils.result(i)) {
            return "修改成功";
        }
        return "修改失败";
    }

}

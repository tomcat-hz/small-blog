package com.blog.service.impl;

import com.blog.bean.BlogComment;
import com.blog.mapper.BlogCommentMapper;
import com.blog.service.BlogCommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class BlogCommentServiceImpl extends ServiceImpl<BlogCommentMapper, BlogComment> implements BlogCommentService {

}

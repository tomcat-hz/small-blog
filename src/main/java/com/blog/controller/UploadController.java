package com.blog.controller;

import com.blog.util.QiNiuUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/28 15:14
 */
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Map<String,Object> upload(MultipartFile file) {
        return QiNiuUtils.upload(file);
    }
}

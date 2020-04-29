package com.blog.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @version V1.0
 * @author: hezheng
 * @date: 2020/4/27 14:42
 */
@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultBean {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";
    private static final Integer CODE_SUCCESS = 0;
    private static final Integer CODE_FAIL = 200;
    private String msg;
    private Integer code;
    private Long count;
    private Object data;


    public ResultBean success(Object data, Long count) {
        ResultBean rb = new ResultBean();
        rb.setCode(CODE_SUCCESS);
        rb.setMsg(SUCCESS);
        rb.setData(data);
        rb.setCount(count);
        return rb;
    }
    public ResultBean success(Object data) {
        ResultBean rb = new ResultBean();
        rb.setCode(CODE_SUCCESS);
        rb.setMsg(SUCCESS);
        rb.setData(data);
        return rb;
    }


    public ResultBean fail(Object data) {
        ResultBean rb = new ResultBean();
        rb.setCode(CODE_FAIL);
        rb.setMsg(FAIL);
        rb.setData(data);
        return rb;
    }

    public ResultBean fail(String msg) {
        ResultBean rb = new ResultBean();
        rb.setMsg(msg);
        return rb;
    }
    public ResultBean success(String msg) {
        ResultBean rb = new ResultBean();
        rb.setMsg(msg);
        return rb;
    }

}

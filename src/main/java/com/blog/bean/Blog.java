package com.blog.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author 何正
 * @since 2020-04-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Blog对象", description="")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "0表示转载,1表示原创")
    private Integer original;

    @ApiModelProperty(value = "0表示不开启评论,1表示开启评论")
    private Integer commentable;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除1存在,0删除")
    @TableLogic
    private Integer flag;

    @ApiModelProperty(value = "0表示不可以赞赏,1表示可以赞赏")
    private Integer appreciate;

    @ApiModelProperty(value = "博客类型的id")
    private Integer typeId;

    @ApiModelProperty(value = "博客的标题")
    private String title;

    @ApiModelProperty(value = "概要")
    private String outline;

    @ApiModelProperty(value = "博客封面")
    private String avatar;

    @ApiModelProperty(value = "博客内容")
    private String content;


}

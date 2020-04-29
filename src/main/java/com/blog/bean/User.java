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
@ApiModel(value="User对象", description="")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户昵称")
    private String usename;

    @ApiModelProperty(value = "注册邮箱")
    private String email;

    @ApiModelProperty(value = "密码")
    private String pass;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "职业")
    private String job;

    @ApiModelProperty(value = "经验等级")
    private Integer level;

    @ApiModelProperty(value = "用户类型0表示管理员,1表示普通用户")
    private Integer userType;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "是否在线0不在,1在")
    private Integer online;

    @ApiModelProperty(value = "逻辑删除1存在,0删除")
    @TableLogic
    private Integer flag;

    @ApiModelProperty(value = "是否签到过")
    private Integer logined;


}

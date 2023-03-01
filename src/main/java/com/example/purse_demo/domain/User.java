package com.example.purse_demo.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 用户信息表
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账号
     */
    @TableField(value = "u_account")
    private String uAccount;

    /**
     * 用户余额
     */
    @TableField(value = "money")
    private Long money;

    /**
     * 版本号
     */
    @TableField(value = "version")
    private Integer version;

    /**
     * 是否删除（0-存在，1-删除）
     */
    @TableField(value = "deleted")
    @TableLogic
    private Integer deleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(value = "update_time")
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
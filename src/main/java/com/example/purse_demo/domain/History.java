package com.example.purse_demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 历史交易明细表
 * @TableName history
 */
@TableName(value ="history")
@Data
public class History implements Serializable {
    /**
     * 交易条目序号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户账号
     */
    @TableField(value = "user_account")
    private String userAccount;

    /**
     * 0-未知 1-存入 2-消费
     */
    @TableField(value = "user_action")
    private Integer userAction;

    /**
     * 操作金额数
     */
    @TableField(value = "changed_money")
    private Long changedMoney;

    /**
     * 操作后总金额数
     */
    @TableField(value = "total_money")
    private Long totalMoney;

    /**
     * 操作时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
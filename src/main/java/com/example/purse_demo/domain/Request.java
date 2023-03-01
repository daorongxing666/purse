package com.example.purse_demo.domain;

import lombok.Data;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

/**
 * @author daorong
 * @version 1.0
 * @description TODO
 * @date 2023/3/1 16:46
 */
@Data
public class Request implements Serializable {


    private static final long serialVersionUID = 574016633049394897L;
    /**
     * 交易用户
     */
    private String userAccount;
    /**
     * 交易金额
     */
    private Long money;
    /**
     * 交易状态 1 - 付款 2 - 退款
     */
    private Integer status;
}

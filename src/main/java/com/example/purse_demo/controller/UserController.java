package com.example.purse_demo.controller;

import com.example.purse_demo.domain.response.ResponseData;
import com.example.purse_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/money")
public class UserController {

    @Autowired
    UserService userService;

    /***
     * @description 查询用户余额
     * @param uAccount 账户名称
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 11:25
     */
    @GetMapping("/{uAccount}")
    public ResponseData getRemain(@PathVariable String uAccount) {
        return userService.getRemain(uAccount);
    }

    /***
     * @description 用户金额改变
     * @param uAccount 用户账号
     * @param money 用户改变金额
     * @param status 状态 1 - 支付 2 - 退款
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 11:48
     */
    @PostMapping("/moneyChanged")
    public ResponseData moneyChanged(@RequestParam String uAccount, @RequestParam Long money, @RequestParam Integer status) {
        return userService.moneyChanged(uAccount, money, status);
    }

}

package com.example.purse_demo.controller;

import com.example.purse_demo.domain.Request;
import com.example.purse_demo.domain.response.ResponseData;
import com.example.purse_demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/money")
public class UserController {

    @Autowired
    UserService userService;

    /***
     * @description 查询用户余额
     * @param userAccount 账户名称
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 11:25
     */
    @GetMapping("/{userAccount}")
    public ResponseData getRemain(@PathVariable String userAccount) {
        return userService.getRemain(userAccount);
    }

    /***
     * @description 用户金额改变
     * @param request 请求封装
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 11:48
     */
    @PostMapping("/moneyChanged")
    public ResponseData moneyChanged(@RequestBody Request request) {
        if(request == null) {
            return ResponseData.buildFailure("400", "输入内容有误，请重试");
        }
        String userAccount = request.getUserAccount();
        Long money = request.getMoney();
        Integer status = request.getStatus();
        if(StringUtils.isAnyBlank(userAccount, money.toString(), status.toString())) {
            return ResponseData.buildFailure("400", "输入内容不能为空");
        }
        return userService.moneyChanged(userAccount, money, status);
    }

}

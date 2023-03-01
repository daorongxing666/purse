package com.example.purse_demo.service;

import com.example.purse_demo.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.purse_demo.domain.response.ResponseData;

/**
* @author centos7
* @description 针对表【user(用户信息表)】的数据库操作Service
* @createDate 2023-03-01 11:14:40
*/
public interface UserService extends IService<User> {
    /***
     * @description 查询用户余额
     * @param userAccount 账户名称
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 11:45
    */
    public ResponseData getRemain(String userAccount);

    /***
     * @description 用户金额改变(存款和取款)
     * @param userAccount 用户账户
     * @param money 用户改变的金额
     * @param status 用户状态
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 11:48
     */
    ResponseData moneyChanged(String userAccount, Long money, Integer status);

}

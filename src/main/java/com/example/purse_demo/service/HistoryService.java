package com.example.purse_demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.purse_demo.domain.History;
import com.example.purse_demo.domain.response.ResponseData;

/**
* @author centos7
* @description 针对表【history(历史交易明细表)】的数据库操作Service
* @createDate 2023-03-01 11:19:39
*/
public interface HistoryService extends IService<History> {

    /***
     * @description 查询用户钱包金额变动明细
     * @param userAccount 用户账号
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 14:13
     */
    ResponseData getHistory(String userAccount);
}

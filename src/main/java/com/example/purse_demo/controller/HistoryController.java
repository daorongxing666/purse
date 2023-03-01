package com.example.purse_demo.controller;

import com.example.purse_demo.domain.response.ResponseData;
import com.example.purse_demo.service.HistoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author daorong
 * @version 1.0
 * @description TODO
 * @date 2023/3/1 14:03
 */
@RestController
@RequestMapping("/history")
public class HistoryController {
    
    @Autowired
    HistoryService historyService;
    
    /***
     * @description 查询用户钱包金额变动明细
     * @param userAccount 用户账号
     * @return com.example.purse_demo.domain.response.ResponseData
     * @author daorong
     * @date 2023/3/1 14:08
    */
    @GetMapping("/{userAccount}")
    public ResponseData getHistory(@PathVariable String userAccount){
        return historyService.getHistory(userAccount);
    }
}

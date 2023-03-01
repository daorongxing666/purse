package com.example.purse_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.purse_demo.domain.History;
import com.example.purse_demo.domain.response.ResponseData;
import com.example.purse_demo.mapper.HistoryMapper;
import com.example.purse_demo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author centos7
* @description 针对表【history(历史交易明细表)】的数据库操作Service实现
* @createDate 2023-03-01 11:19:39
*/
@Service
public class HistoryServiceImpl extends ServiceImpl<HistoryMapper, History>
    implements HistoryService{

    @Autowired
    HistoryMapper historyMapper;
    @Override
    public ResponseData getHistory(String uAccount) {
        QueryWrapper<History> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(History::getUserAccount, uAccount);
        List<History> histories = historyMapper.selectList(queryWrapper);
        return ResponseData.buildSuccess(histories);
    }
}





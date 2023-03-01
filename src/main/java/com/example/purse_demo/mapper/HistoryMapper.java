package com.example.purse_demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.purse_demo.domain.History;
import org.springframework.stereotype.Component;

/**
* @author centos7
* @description 针对表【history(历史交易明细表)】的数据库操作Mapper
* @createDate 2023-03-01 11:19:39
* @Entity com.example.purse_demo.domain.History
*/
@Component
public interface HistoryMapper extends BaseMapper<History> {

}





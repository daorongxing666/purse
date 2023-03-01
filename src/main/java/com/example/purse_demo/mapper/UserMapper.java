package com.example.purse_demo.mapper;

import com.example.purse_demo.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

/**
* @author centos7
* @description 针对表【user(用户信息表)】的数据库操作Mapper
* @createDate 2023-03-01 11:14:40
* @Entity .domain.User
*/
@Component
public interface UserMapper extends BaseMapper<User> {

}





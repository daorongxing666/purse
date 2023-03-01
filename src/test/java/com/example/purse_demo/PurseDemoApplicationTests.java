package com.example.purse_demo;
import java.util.Date;

import com.example.purse_demo.domain.User;
import com.example.purse_demo.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PurseDemoApplicationTests {

    @Resource
    UserMapper userMapper;

    /***
     * @description 表中插入数据
     * @return void
     * @author daorong
     * @date 2023/3/1 14:24
    */
    @Test
    void InsertTest() {
        User user = new User();
        user.setUAccount("zhangsan");
        user.setMoney(500L);
        userMapper.insert(user);
    }

}

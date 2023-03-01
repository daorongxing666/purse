package com.example.purse_demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.purse_demo.domain.History;
import com.example.purse_demo.domain.User;
import com.example.purse_demo.domain.response.ResponseData;
import com.example.purse_demo.mapper.HistoryMapper;
import com.example.purse_demo.service.UserService;
import com.example.purse_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author centos7
* @description 针对表【user(用户信息表)】的数据库操作Service实现
* @createDate 2023-03-01 11:14:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    HistoryMapper historyMapper;
    @Override
    public ResponseData getRemain(String uAccount) {
        User user = getUser(uAccount);
        if (user == null) {
            String errMsg = "该用户不存在";
            log.debug(errMsg);
            return ResponseData.buildFailure("400", errMsg);
        }
        // 获取用户余额
        Long money = user.getMoney();
        return ResponseData.buildSuccess(money);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseData moneyChanged(String uAccount, Long money, Integer status) {
        Long remainMoney = (Long)this.getRemain(uAccount).getData();
        // 判断余额是否足够取款
        if (status == 1 && remainMoney < money) {
            String errMsg = "账户余额不足";
            log.debug(errMsg);
            return ResponseData.buildFailure("400", errMsg);
        }
        // 账户表中扣除余额，版本号更新
        User user = getUser(uAccount);
        switch (status) {
            case 1 :
                user.setMoney(user.getMoney() - money);
                break;
            case 2 :
                user.setMoney(user.getMoney() + money);
                break;
            default:
                return ResponseData.buildFailure("400", "操作错误，请稍后再试");
        }
        user.setVersion(user.getVersion() + 1);
        userMapper.updateById(user);
        // 历史表中增加一条资金变动记录
        History history = new History();
        history.setUserAccount(uAccount);
        history.setUserAction(status);
        history.setChangedMoney(money);
        history.setTotalMoney(user.getMoney());
        historyMapper.insert(history);
        return ResponseData.buildSuccess(history);
    }


    /***
     * @description 根据账户名查询用户
     * @param uAccount 账户名
     * @return com.example.purse_demo.domain.User
     * @author daorong
     * @date 2023/3/1 11:59
     */
    public User getUser(String uAccount) {
        // 查询用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(User::getUAccount, uAccount);
        return this.getOne(queryWrapper);
    }
}





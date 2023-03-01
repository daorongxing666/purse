# 工程简介
模拟电商平台用户钱包，有查看余额，付款退款，以及查看历史交易的功能

# 项目特点
1. 将消费和退款两种相似的操作合并，降低代码耦合度
2. 运用数据库事务操作，保证了用户表和消费历史记录表的一致性
3. 在用户余额变动时运用了乐观锁，在保证性能的情况下确保了线程安全问题
# 测试效果
### 查询用户剩余金额
GET http://localhost:8080/money/zhangsan
```json
{
  "code": "200",
  "message": null,
  "data": 220
}
```


### 用户消费100元
http://localhost:8080/money/moneyChanged
```json
// 表单json
{
  "userAccount": "zhangsan",
  "money": 100,
  "status": 1
}

// 响应json
{
  "code": "200",
  "message": null,
  "data": {
    "id": 3,
    "userAccount": "zhangsan",
    "userAction": 1,
    "changedMoney": 100,
    "totalMoney": 200,
    "createTime": 2023-03-01 15:46:37
  }
}
```



### 用户退款20元
http://localhost:8080/money/moneyChanged
```json
// 表单json
{
  "userAccount": "zhangsan",
  "money": 20,
  "status": 2
}
// 响应json
{
  "code": "200",
  "message": null,
  "data": {
    "id": 4,
    "userAccount": "zhangsan",
    "userAction": 2,
    "changedMoney": 20,
    "totalMoney": 220,
    "createTime": 2023-03-01  15: 48: 32
  }
}
```


### 查询用户钱包金额变动明细
GET http://localhost:8080/history/zhangsan

```json
{
  "code": "200",
  "message": null,
  "data": [
    {
      "id": 3,
      "userAccount": "zhangsan",
      "userAction": 1,
      "changedMoney": 100,
      "totalMoney": 200,
      "createTime": "2023-03-01T07:46:37.000+00:00"
    },
    {
      "id": 4,
      "userAccount": "zhangsan",
      "userAction": 2,
      "changedMoney": 20,
      "totalMoney": 220,
      "createTime": "2023-03-01T07:48:32.000+00:00"
    }
  ]
}
```



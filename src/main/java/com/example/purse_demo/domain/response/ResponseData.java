package com.example.purse_demo.domain.response;

import lombok.Data;

/**
 * @author daorong
 * @version 1.0
 * @description 响应数据封装
 * @date 2023/3/1 11:32
 */
@Data
public class ResponseData<T> {

    /**
     * 状态码
     */
    private String code;

    /**
     * 响应信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;

    /**
     * 成功消息返回
     */
    public static <T> ResponseData<T> buildSuccess(T data) {
        ResponseData response = new ResponseData();
        response.setCode("200");
        response.setData(data);
        return response;
    }

    /**
     * 失败消息返回
     */
    public static ResponseData buildFailure(String errCode, String errMessage) {
        ResponseData response = new ResponseData();
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

}

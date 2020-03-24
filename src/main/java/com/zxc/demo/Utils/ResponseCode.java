package com.zxc.demo.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应包装方法
 * @param <T>
 */

@Data
@AllArgsConstructor
public class ResponseCode<T> implements Serializable {

    private Integer code;
    private String message;
    private Object data;

    private ResponseCode(StatusEnmus responseCode) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }

    private ResponseCode(StatusEnmus responseCode, T data) {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
        this.data = data;
    }

    private ResponseCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


    /**
     * 返回成功信息
     * @param data      信息内容
     * @param <T>
     * @return
     */
    public static<T> ResponseCode success(T data) {
        return new ResponseCode<>(StatusEnmus.SUCCESS, data);
    }


    /**
     * 返回成功信息
     * @return
     */
    public static ResponseCode success() {
        return new ResponseCode(StatusEnmus.SUCCESS);
    }


    /**
     * 返回错误信息
     * @param statusEnums      响应码
     * @return
     */
    public static ResponseCode error(StatusEnmus statusEnums) {
        return new ResponseCode(statusEnums);
    }

}

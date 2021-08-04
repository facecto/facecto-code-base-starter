package com.facecto.code.base;

import com.facecto.code.base.enums.ResultMessage;
import com.facecto.code.base.enums.ResultStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/8/4
 */
@Data
@AllArgsConstructor
public class CodeResult<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private T data;
    private Integer code;
    private String message;
    private ResultStatus status;

    public CodeResult() {
        this.code = 0;
        this.message = ResultMessage.SYSTEM_OK.getValue();
        this.status = ResultStatus.SUCCESS;
    }

    private CodeResult(Integer code, String message, ResultStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    private CodeResult(Integer code, String message, ResultStatus status, T data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static <T> CodeResult<T> error() {
        return new CodeResult(HttpStatus.SC_INTERNAL_SERVER_ERROR, ResultMessage.SYSTEM_ERROR.getValue(), ResultStatus.FAIL);
    }

    public static <T> CodeResult<T> error(String message) {
        return new CodeResult(HttpStatus.SC_INTERNAL_SERVER_ERROR, message, ResultStatus.FAIL);
    }

    public static <T> CodeResult<T> error(int code, String message) {
        return new CodeResult(code, message, ResultStatus.FAIL);
    }

    public static <T> CodeResult<T> ok() {
        return new CodeResult();
    }


    public static <T> CodeResult<T> ok(String message) {
        return new CodeResult(0, message, ResultStatus.SUCCESS);
    }

    public static <T> CodeResult<T> ok(String message, T data) {
        return new CodeResult(0, message, ResultStatus.SUCCESS, data);
    }

    public static <T> CodeResult<T> okx(T data) {
        return new CodeResult(0, ResultMessage.SYSTEM_SUCCESS.getValue(), ResultStatus.SUCCESS, data);
    }

}
package com.facecto.code.base;

import com.facecto.code.base.enums.ResultMessageEnum;
import com.facecto.code.base.enums.ResultStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.HttpStatus;

import java.io.Serializable;

/**
 * The basic return information
 * @author Jon So, https://cto.pub, https://github.com/facecto
 * @version v1.1.0 (2021/08/08)
 */
@Data
@AllArgsConstructor
public class CodeResult<T> implements Serializable {
    private static final long serialVersionUID = 6374486752803150412L;
    private T data;
    private Integer code;
    private String message;
    private ResultStatusEnum status;

    public CodeResult() {
        this.code = 0;
        this.message = ResultMessageEnum.SYSTEM_OK.getValue();
        this.status = ResultStatusEnum.SUCCESS;
    }

    private CodeResult(Integer code, String message, ResultStatusEnum status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    private CodeResult(Integer code, String message, ResultStatusEnum status, T data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    /**
     * Get CodeResult while error
     * @param <T> the type of target
     * @return CodeResult
     */
    public static <T> CodeResult<T> error() {
        return new CodeResult(HttpStatus.SC_INTERNAL_SERVER_ERROR, ResultMessageEnum.SYSTEM_ERROR.getValue(), ResultStatusEnum.FAIL);
    }

    /**
     * Get CodeResult while error
     * @param message error message
     * @param <T> the type of target
     * @return CodeResult
     */
    public static <T> CodeResult<T> error(String message) {
        return new CodeResult(HttpStatus.SC_INTERNAL_SERVER_ERROR, message, ResultStatusEnum.FAIL);
    }

    /**
     * Get CodeResult while error
     * @param code error code
     * @param message error message
     * @param <T> the type of target
     * @return CodeResult
     */
    public static <T> CodeResult<T> error(int code, String message) {
        return new CodeResult(code, message, ResultStatusEnum.FAIL);
    }

    /**
     * Get CodeResult just ok
     * @param <T> the type of target
     * @return CodeResult
     */
    public static <T> CodeResult<T> ok() {
        return new CodeResult();
    }

    /**
     * Get CodeResult only one param message
     * @param message message
     * @param <T> the type of target
     * @return CodeResult
     */
    public static <T> CodeResult<T> ok(String message) {
        return new CodeResult(0, message, ResultStatusEnum.SUCCESS);
    }

    /**
     * Get CodeResult for message and data
     * @param message message
     * @param data data body
     * @param <T> the type of target
     * @return CodeResult
     */
    public static <T> CodeResult<T> ok(String message, T data) {
        return new CodeResult(0, message, ResultStatusEnum.SUCCESS, data);
    }

    /**
     * Get CodeResult only one param with data body
     * @param data data body
     * @param <T> the type of target
     * @return CodeResult
     */
    public static <T> CodeResult<T> okx(T data) {
        return new CodeResult(0, ResultMessageEnum.SYSTEM_SUCCESS.getValue(), ResultStatusEnum.SUCCESS, data);
    }

}
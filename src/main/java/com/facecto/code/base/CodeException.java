package com.facecto.code.base;

import lombok.Getter;
import lombok.Setter;

/**
 * the basic exception
 * @author Jon So, https://cto.pub, https://facecto.com, https://github.com/facecto
 * @version v1.1.0 (2021/8/08)
 */
@Getter
@Setter
public class CodeException extends RuntimeException {
    private static final long serialVersionUID = 4056355647005042739L;
    private String message;
    private String status;
    private Integer code = 500;

    /**
     * CodeException with message
     * @param message message
     */
    public CodeException(String message) {
        super(message);
        this.message = message;
    }

    /**
     * CodeException with message, throwable
     * @param message message
     * @param e throwable
     */
    public CodeException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    /**
     * CodeException with message, code
     * @param message message
     * @param code error code
     */
    public CodeException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    /**
     * CodeException with message, code, throwable
     * @param message message
     * @param code error code
     * @param e throwable
     */
    public CodeException(String message, int code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }

}

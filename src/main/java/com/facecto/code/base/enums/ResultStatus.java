package com.facecto.code.base.enums;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/5/01
 */
public enum ResultStatus {
    SUCCESS(0),
    FAIL(1);
    private int code;

    ResultStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name();
    }
}

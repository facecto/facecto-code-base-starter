package com.facecto.code.base.enums;

/**
 * The enum for result status
 *
 * @author Jon So, https://facecto.com, https://github.com/facecto
 * @version v1.1.0 (2021/08/08)
 */
public enum ResultStatusEnum {
    SUCCESS(0),
    FAIL(1);
    private int code;

    ResultStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public String getName() {
        return this.name();
    }
}

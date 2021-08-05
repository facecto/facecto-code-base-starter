package com.facecto.code.base.enums;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/5/01
 */
public enum ResultMessage {
    SYSTEM_ERROR("SYSTEM ERROR！"),
    SYSTEM_SUCCESS("SUCCESS！"),
    SYSTEM_OK("OK！");
    String value;

    ResultMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

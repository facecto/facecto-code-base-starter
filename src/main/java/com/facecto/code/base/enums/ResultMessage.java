package com.facecto.code.base.enums;

/**
 * @author Jon So
 * @author page https://cto.pub
 * @date 2021/5/01
 */
public enum ResultMessage {
    SYSTEM_ERROR("系统异常，请联系管理员！"),
    SYSTEM_SUCCESS("成功"),
    SYSTEM_OK("OK");
    String value;

    ResultMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

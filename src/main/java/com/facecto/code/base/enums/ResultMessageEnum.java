package com.facecto.code.base.enums;

/**
 * The enum for result message
 *
 * @author Jon So, https://cto.pub, https://github.com/facecto
 * @version v1.1.0 (2021/08/08)
 */
public enum ResultMessageEnum {
    SYSTEM_ERROR("System error!"),
    SYSTEM_SUCCESS("Everything are well done!"),
    SYSTEM_OK("OK!");
    String value;

    ResultMessageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

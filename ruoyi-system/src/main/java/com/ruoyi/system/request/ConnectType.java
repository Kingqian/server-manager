package com.ruoyi.system.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author tjq
 * @since 30/10/2023
 */
@Getter
@AllArgsConstructor
public enum ConnectType {


    /* 密码登录 */
    PWD("PWD"),

    /* 私钥登录 */
    PRIVATEKEY("PRIVATEKEY"),
    ;

    private final String value;

    public static ConnectType find(String val) {
        for (ConnectType type : ConnectType.values()) {
            if (type.getValue().equals(val)) {
                return type;
            }
        }
        return null;
    }
}

package io.github.renestel.notion.domain.model.base;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(enumAsRef = true)
public enum ErrorCode {
    UNKNOWN(null),
    PROXY_LOGIC_EXCEPTION("ProxyLogicException");

    private final String name;

    ErrorCode(String name) {
        this.name = name;
    }

    public static ErrorCode from(String str) {
        if (str == null)
            return ErrorCode.UNKNOWN;

        switch (str) {
            default:
                return ErrorCode.UNKNOWN;
            case "ProxyLogicException":
                return ErrorCode.PROXY_LOGIC_EXCEPTION;
        }
    }
}

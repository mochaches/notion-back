package io.github.renestel.notion.provider.proxy.api;

import io.github.renestel.notion.domain.model.base.ErrorCode;
import lombok.Getter;

public class ProxyLogicException extends Exception {
    @Getter
    private final ErrorCode code;

    public ProxyLogicException(String message) {
        super(message);
        this.code = ErrorCode.UNKNOWN;
    }

    public ProxyLogicException(String message, ErrorCode errorCode) {
        super(message);
        this.code = errorCode;
    }
}

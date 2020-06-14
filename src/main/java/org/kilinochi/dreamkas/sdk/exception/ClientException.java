package org.kilinochi.dreamkas.sdk.exception;

/**
 * @author arman.shamenov
 */
public class ClientException extends RuntimeException {
    private final int code;

    public ClientException(Throwable cause) {
        super(cause);
        this.code = 400;
    }

    public ClientException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}

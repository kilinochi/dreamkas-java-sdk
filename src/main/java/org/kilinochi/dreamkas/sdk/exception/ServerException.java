package org.kilinochi.dreamkas.sdk.exception;

/**
 * @author arman.shamenov
 */
public class ServerException extends RuntimeException {
    private final int code;

    public ServerException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public ServerException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServerException(String message) {
        super(message);
        this.code = 500;
    }

    public int getCode() {
        return code;
    }
}

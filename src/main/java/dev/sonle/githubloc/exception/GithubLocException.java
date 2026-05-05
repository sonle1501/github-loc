package dev.sonle.githubloc.exception;

import lombok.Getter;

@Getter
public class GithubLocException extends RuntimeException {
    private final ErrorCode errorCode;

    public GithubLocException(ErrorCode errorCode) {
        super(errorCode.getDefaultMessage());
        this.errorCode = errorCode;
    }

    public GithubLocException(ErrorCode errorCode, Throwable cause) {
        super(buildMessage(errorCode, null, cause), cause);
        this.errorCode = errorCode;
    }

    public GithubLocException(ErrorCode errorCode, String customMessage) {
        super(buildMessage(errorCode, customMessage, null));
        this.errorCode = errorCode;
    }

    public GithubLocException(ErrorCode errorCode, String customMessage, Throwable cause) {
        super(buildMessage(errorCode, customMessage, cause), cause);
        this.errorCode = errorCode;
    }

    private static String buildMessage(ErrorCode code, String msg, Throwable cause) {
        String error = code.name();

        if (msg != null && cause != null) {
            return error + ": " + msg + " | cause: " + cause.getMessage();
        }
        if (msg != null) {
            return error + ": " + msg;
        }
        if (cause != null) {
            return error + ": " + cause.getMessage();
        }
        return error;
    }
}

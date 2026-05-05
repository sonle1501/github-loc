package dev.sonle.githubloc.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    INTERRUPTED(1, "Operation interrupted"),
    REPO_DOWNLOAD_FAILED(2, "Failed to download repository"),
    UNEXPECTED_ERROR(3, "Unexpected error occurred"),
    INVALID_INPUT(4, "Invalid input arguments"),
    FILE_PROCESSING_ERROR(5, "Error while processing file"),
    REPO_TREE_CREATION_FAILED(6, "Failed to create repo tree"),
    GITHUB_API_ERROR(7, "Error while using github api"),
    JSON_PROCESSING_ERROR(8, "Error processing JSON");

    private final int exitCode;
    private final String defaultMessage;

    ErrorCode(int code, String message) {
        this.exitCode = code;
        this.defaultMessage = message;
    }
}

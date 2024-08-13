package com.sartyro.pubberrestapi.exception;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record ApiError(
        @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss.SS") LocalDateTime timestamp,
        Integer status,
        String error,
        String path,
        String message
) {
}

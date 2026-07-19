package com.pamapay.common.exception;
import java.util.Map;
import java.time.Instant;
public record ValidationErrorResponse (
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        Map<String,String> fieldErrors
){

}

package com.facecto.code.base.handler;

import com.facecto.code.base.CodeException;
import com.facecto.code.base.CodeResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * CodeException handler
 *
 * @author Jon So, https://cto.pub, https://facecto.com, https://github.com/facecto
 * @version v1.1.0 (2021/8/08)
 */
@Slf4j
@RestControllerAdvice
public class CodeExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public CodeResult handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("Params error.");
        return CodeResult.error(500, "Params error.");
    }

    @ExceptionHandler(SecurityException.class)
    public CodeResult handleSecurityException(SecurityException e) {
        log.error("No access allowed.");
        return CodeResult.error(500, "No access allowed.");
    }

    @ExceptionHandler(NullPointerException.class)
    public CodeResult handleNullPointerException(NullPointerException e) {
        log.error("Null pointer exception.");
        return CodeResult.error(500, "Null pointer exception.");
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public CodeResult handlerNoFoundException(NoHandlerFoundException e) {
        log.error(e.getMessage(), e);
        return CodeResult.error(404, "Corresponding resource not found.");
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public CodeResult handlerHttpMediaTypeNotSupportedException(HttpMediaTypeNotSupportedException e) {
        log.error("Request type is not supported.");
        return CodeResult.error(500, "Request type is not supported.");
    }

    @ExceptionHandler(CodeException.class)
    public CodeResult handleCodeException(CodeException e) {
        return CodeResult.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public CodeResult handleRuntimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return CodeResult.error(500, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public CodeResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return CodeResult.error(e.getLocalizedMessage());
    }
}
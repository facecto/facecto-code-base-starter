package com.facecto.code.base.handler;

import com.facecto.code.base.CodeException;
import com.facecto.code.base.CodeResult;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;

/**
 * CodeException handler resolver
 *
 * @author Jon So, https://cto.pub, https://facecto.com, https://github.com/facecto
 * @version v1.1.0 (2021/8/08)
 */
@Component
public class CodeExceptionHandlerResolver implements HandlerExceptionResolver {

    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * resolveException
     *
     * @param httpServletRequest  HttpServletRequest
     * @param httpServletResponse HttpServletResponse
     * @param o                   object
     * @param e                   exception
     * @return ModelAndView
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        String message = e.getMessage();
        Integer code = 500;
        if (e instanceof CodeException) {
            CodeException cc = (CodeException) e;
            code = cc.getCode();
        }

        if (o instanceof HandlerMethod) {
            if (e instanceof IllegalArgumentException) {
                message = "Params error.";
            } else if (e instanceof SecurityException) {
                message = "No access allowed.";
            } else if (e instanceof NullPointerException) {
                message = "Null pointer exception.";
            }
        } else if (e instanceof NoHandlerFoundException) {
            message = "Corresponding resource not found.";
        } else if (e instanceof HttpMediaTypeNotSupportedException) {
            message = "Request type is not supported.";
        }
        e.printStackTrace();
        httpServletResponse.setCharacterEncoding(StandardCharsets.UTF_8.name());
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

        try {
            httpServletResponse.getWriter()
                    .write(
                            OBJECT_MAPPER.writeValueAsString(
                                    CodeResult.error(code, message)
                            )
                    );
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new ModelAndView();
    }
}

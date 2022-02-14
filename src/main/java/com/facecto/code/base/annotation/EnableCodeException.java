package com.facecto.code.base.annotation;

import com.facecto.code.base.config.CodeExceptionAutoConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * Annotation EnableCodeException
 * @author Jon So, https://cto.pub, https://facecto.com, https://github.com/facecto
 * @version v1.1.2 (2022/02/01)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(CodeExceptionAutoConfiguration.class)
@Documented
@Inherited
public @interface EnableCodeException {
}

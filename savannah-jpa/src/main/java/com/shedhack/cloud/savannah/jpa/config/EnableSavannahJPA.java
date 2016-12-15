package com.shedhack.cloud.savannah.jpa.config;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <pre>
 *     Simplifies the configuration of the JPA entities/repo etc, does require a DS to have been created.
 * </pre>
 *
 * @author imamchishty
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Import(SavannahJPAConfiguration.class)
public @interface EnableSavannahJPA {
}

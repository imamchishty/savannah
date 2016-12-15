package com.shedhack.cloud.savannah.server.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * <pre>
 *     Starts an instance of Savannah Server.
 * </pre>
 *
 * @author imamchishty
 */
@Target({java.lang.annotation.ElementType.TYPE})
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
@Import(SavannahServerConfiguration.class)
public @interface EnableSavannahServer {
}

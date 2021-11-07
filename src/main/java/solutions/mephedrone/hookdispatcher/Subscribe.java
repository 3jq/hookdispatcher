package solutions.mephedrone.hookdispatcher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yoursleep
 * @since 08 November 2021
 */
@Retention(RetentionPolicy.RUNTIME) @Target(ElementType.METHOD) public @interface Subscribe {}
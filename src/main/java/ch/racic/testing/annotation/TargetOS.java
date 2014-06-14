/*
 * Copyleft (c) 2014. This code is for learning purposes only. Do whatever you like with it but don't take it as perfect code.
 * This code lab has been developed by Michel Racic (http://rac.su/+) and funded partially by Credit Suisse AG (http://www.credit-suisse.ch) and GDG Zürich (http://www.gdgzh.ch).
 */

/*
 * Copyleft (c) 2014. This code is for learning purposes only. Do whatever you like with it but don't take it as perfect code.
 * Michel Racic (http://rac.su/+) => github.com/rac2030
 */

package ch.racic.testing.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by rac on 14.06.14.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetOS {
    String family();

    String name() default "";

    String arch() default "";

    String version() default "";
}

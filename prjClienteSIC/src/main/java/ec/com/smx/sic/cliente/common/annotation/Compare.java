package ec.com.smx.sic.cliente.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Clase para el control de b&uacute;squeda de un campo que va a ser auditado 
 * @author mhidalgo
 * @since jdk 1.6
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Compare {

}

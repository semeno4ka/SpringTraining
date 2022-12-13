package com.cydeo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
//(type=class) we define the scope of the annotation, such as method level annotation
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggingAnnotation {


}

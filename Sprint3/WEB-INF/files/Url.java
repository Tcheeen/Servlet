package etu2063.framework.annot;

import java.lang.annotation.*;

@Target(ElementType.METHOD)

@Retention(RetentionPolicy.RUNTIME)

public @interface Url{
    public String url() default "";
}
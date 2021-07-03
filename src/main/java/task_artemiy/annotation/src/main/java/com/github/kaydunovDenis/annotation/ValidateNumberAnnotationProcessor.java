package com.github.kaydunovDenis.annotation;

import lombok.extern.java.Log;

import java.lang.reflect.Field;

@Log
public class ValidateNumberAnnotationProcessor {
    public boolean process(Object object) throws Exception {
        boolean result = false;
        Class<?> clazz = object.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field:declaredFields
        ) {
            if (field.isAnnotationPresent(ValidateNumber.class)) {
                field.setAccessible(true);
                Integer value = (Integer) field.get(object);
                result = value < 10;
                log.info("Number " + field.getName() + "=" + value + " < 10: " + result);
            }
        }
        return result;
    }
}

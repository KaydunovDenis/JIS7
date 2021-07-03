package com.github.kaydunovDenis;


import org.apache.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeFrameDefinitionAnnotationProcessor {
    final static Logger LOGGER = Logger.getLogger(TimeFrameDefinitionAnnotationProcessor.class);

    public void execute(Object object) throws InvocationTargetException, IllegalAccessException {
        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(TimeFrameDefinition.class)) {
                long start = System.currentTimeMillis();
                LOGGER.info("Start: " + start);
                if (method.getParameterCount() > 0) {
                    method.invoke(object, 10, 20);
                } else {
                    method.invoke(object);
                }
                LOGGER.info("ExecutionTime: " + (System.currentTimeMillis() - start));
            }
        }
    }
}

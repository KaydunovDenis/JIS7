package com.github.kaydunovDenis;

import com.github.kaydunovDenis.model.CalculatorObject;

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        CalculatorObject calculatorObject = new CalculatorObject();
        System.out.println(calculatorObject);

        GenerateIntegerValueAnnotationProcessor processor = new GenerateIntegerValueAnnotationProcessor();
        processor.analyze(calculatorObject);
        System.out.println(calculatorObject);
    }

    @TimeFrameDefinition
    public void init() {

    }
}

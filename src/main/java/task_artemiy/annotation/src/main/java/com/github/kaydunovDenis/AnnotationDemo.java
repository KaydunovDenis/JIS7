package com.github.kaydunovDenis;

import com.github.kaydunovDenis.annotation.ValidateNumberAnnotationProcessor;
import com.github.kaydunovDenis.model.PermissionToAccess;
import com.github.kaydunovDenis.model.SecondProduct;

public class AnnotationDemo {
    public static void main(String[] args) throws Exception {
        var processor = new ValidateNumberAnnotationProcessor();

        PermissionToAccess permission = new PermissionToAccess(-5);
        SecondProduct product = new SecondProduct(9, 120);

        processor.process(permission);
        processor.process(product);
    }
}

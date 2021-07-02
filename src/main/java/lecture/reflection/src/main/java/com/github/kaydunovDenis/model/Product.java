package com.github.kaydunovDenis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    public String publicName;
    private String privateName;
    private Product() {
    }

    public void printGreet() {
        System.out.println("Aloha!");
    }

    public String printYourGreet(String yourGritting) {
        return yourGritting + "!!!";
    }



    private void privatePrintGreet() {
        System.out.println("Private Aloha!");
    }

    private String privatePrintYourGreet(String yourGritting) {
        return "Private Greet:" + yourGritting + "!!!";
    }
}

package com.github.kaydunovDenis.crud.model;

public enum ProductCategory {
    PHONE("Телефон"),
    TABLET("Планшет"),
    NOTEBOOK("Ноутбук"),
    COMPUTER("Компьютер");

    private final String category;

    ProductCategory(String category) {
        this.category = category;
    }

    public static boolean contains(String test) {
        for (ProductCategory productCategory : ProductCategory.values()) {
            if (productCategory.name().equals(test)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return category;
    }
}

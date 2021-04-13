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

    @Override
    public String toString() {
        return category;
    }
}

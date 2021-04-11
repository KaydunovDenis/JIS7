package com.github.KaydunovDenis.crud.Repository;

public enum Category {
    PHONE ("Телефон"),
    TABLET("Планшет"),
    NOTEBOOK("Ноутбук"),
    COMPUTER("Компьютер");

    private final String category;

    Category(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category;
    }
}

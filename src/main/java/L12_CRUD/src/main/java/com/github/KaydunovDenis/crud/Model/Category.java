package com.github.KaydunovDenis.crud.Model;

public enum Category {
    PHONE ("Телефон"),
    TABLET("Планшет"),
    NOTEBOOK("Ноутбук"),
    COMPUTER("Компьютер");

    private final String title;

    Category(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }
}

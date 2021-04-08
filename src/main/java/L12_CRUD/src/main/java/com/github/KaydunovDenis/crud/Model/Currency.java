package com.github.KaydunovDenis.crud.Model;

public enum Currency {
    EUR("Евро"),
    USD("Доллар США"),
    RUB("Российский рубль"),
    BYN("Беларусский рубль");

    private final String title;

    Currency(String currencyName) {
        this.title = currencyName;
    }

    @Override
    public String toString() {
        return title;
    }
}

package com.github.KaydunovDenis.crud.model;

public abstract class SuperProduct {
    public String name;
    final public Long ID;
    private static Long counterID = 0L;
    public Currency currency;
    private final Currency DEFOULT_CURRENCY = Currency.EUR;

    public SuperProduct() {
        ID = counterID++;
        currency = DEFOULT_CURRENCY;
    }

}

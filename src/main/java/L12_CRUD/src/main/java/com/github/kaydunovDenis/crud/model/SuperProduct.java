package com.github.kaydunovDenis.crud.model;

public abstract class SuperProduct {
    public String name;
    final public Long ID;
    private static Long counterID = 0L;

    public SuperProduct() {
        ID = counterID++;
    }

}

package com.github.KaydunovDenis.crud.Repository;

public abstract class SuperProduct {
    private static Long counterID = 0L;
    public Long id;
    private ProductRepository productRepository = new ProductRepository();
    private Currency defoultCurrencyCurrency = productRepository.getDefoultCurrency();
    public Currency currency;

    public SuperProduct() {
        id = counterID++;
        currency = defoultCurrencyCurrency;
    }

}

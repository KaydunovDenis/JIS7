package com.github.KaydunovDenis.crud.Service;

import com.github.KaydunovDenis.crud.Database.Model;

public abstract class SuperProduct {
    private static Long counterID = 0L;
    public Long id;
    private Model model = new Model();
    private Currency defoultCurrencyCurrency = model.getDefoultCurrency();
    public Currency currency;

    public SuperProduct() {
        id = counterID++;
        currency = defoultCurrencyCurrency;
    }

}

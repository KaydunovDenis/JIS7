package com.github.KaydunovDenis.crud.Model;

import com.github.KaydunovDenis.crud.Model.Currency;
import com.github.KaydunovDenis.crud.Model.Model;

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

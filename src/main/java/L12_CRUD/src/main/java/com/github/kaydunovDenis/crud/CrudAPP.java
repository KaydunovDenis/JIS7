package com.github.kaydunovDenis.crud;

import com.github.kaydunovDenis.crud.service.CrudService;

public class CrudAPP {
    public static void main(String[] args) {
        CrudService crudService = new CrudService();
        crudService.getPRODUCT_REPOSITORY().initialProductRepository();
        System.out.println(crudService.getPRODUCT_REPOSITORY().getPRODUCTS().toString());
    }
}

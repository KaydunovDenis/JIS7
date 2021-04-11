package com.github.KaydunovDenis.crud.service;

public interface UserCommandRepository {
    void create(String[] array);
    void read(String id);
    void readALL();
    void update();
    void delete(String[] command);
}

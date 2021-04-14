package com.github.kaydunovDenis.crud.service;

public interface UserCommandRepository {
    void create(String[] array);
    void read(String[] command) throws ErrorCommandException;
    void readALL() throws ErrorCommandException;
    void update(String[] command) throws ErrorCommandException;
    void delete(String[] command) throws ErrorCommandException;
}

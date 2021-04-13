package com.github.kaydunovDenis.crud.service;

public interface UserCommandRepository {
    void create(String[] array) throws ErrorCommandException;
    void read(String[] command) throws ErrorCommandException;
    void readALL(String[] command) throws ErrorCommandException;
    void update(String[] command) throws ErrorCommandException;
    void delete(String[] command) throws ErrorCommandException;
}

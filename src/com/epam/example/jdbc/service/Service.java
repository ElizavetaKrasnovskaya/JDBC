package com.epam.example.jdbc.service;

import java.util.List;

public interface Service<T> {

    T getById(int id);

    List<T> getAll();

    boolean create(T t);

    T update(T t);

    boolean deleteById(int id);

}

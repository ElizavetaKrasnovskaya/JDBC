package com.epam.example.jdbc.dao;

import java.util.List;

public interface Dao<T> {

    T getById(int id);

    List<T> getAll();

    boolean create(T t);

    T update(T t);

    boolean deleteById(int id);

}

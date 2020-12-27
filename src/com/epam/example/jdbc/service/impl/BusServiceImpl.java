package com.epam.example.jdbc.service.impl;

import com.epam.example.jdbc.dao.Dao;
import com.epam.example.jdbc.dao.impl.BusDaoImpl;
import com.epam.example.jdbc.model.Bus;
import com.epam.example.jdbc.service.Service;

import java.util.List;

public class BusServiceImpl implements Service<Bus> {

    private final Dao<Bus> dao = new BusDaoImpl();

    @Override
    public Bus getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Bus> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean create(Bus bus) {
        return dao.create(bus);
    }

    @Override
    public Bus update(Bus bus) {
        return dao.update(bus);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }
}

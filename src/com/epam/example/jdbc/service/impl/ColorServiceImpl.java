package com.epam.example.jdbc.service.impl;

import com.epam.example.jdbc.dao.Dao;
import com.epam.example.jdbc.dao.impl.ColorDaoImpl;
import com.epam.example.jdbc.model.Color;
import com.epam.example.jdbc.service.Service;

import java.util.List;


public class ColorServiceImpl implements Service<Color> {

    private final Dao<Color> dao = new ColorDaoImpl();

    @Override
    public Color getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Color> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean create(Color color) {
        return dao.create(color);
    }

    @Override
    public Color update(Color color) {
        return dao.update(color);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }
}

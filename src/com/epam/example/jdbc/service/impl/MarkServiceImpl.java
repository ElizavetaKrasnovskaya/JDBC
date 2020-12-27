package com.epam.example.jdbc.service.impl;

import com.epam.example.jdbc.dao.Dao;
import com.epam.example.jdbc.dao.impl.MarkDaoImpl;
import com.epam.example.jdbc.model.Mark;
import com.epam.example.jdbc.service.Service;

import java.util.List;

public class MarkServiceImpl implements Service<Mark> {

    private final Dao<Mark> dao = new MarkDaoImpl();

    @Override
    public Mark getById(int id) {
        return dao.getById(id);
    }

    @Override
    public List<Mark> getAll() {
        return dao.getAll();
    }

    @Override
    public boolean create(Mark mark) {
        return dao.create(mark);
    }

    @Override
    public Mark update(Mark mark) {
        return dao.update(mark);
    }

    @Override
    public boolean deleteById(int id) {
        return dao.deleteById(id);
    }
}

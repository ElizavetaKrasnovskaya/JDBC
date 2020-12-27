package com.epam.example.jdbc.dao.impl;

import com.epam.example.jdbc.dao.Dao;
import com.epam.example.jdbc.model.Mark;
import com.epam.example.jdbc.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MarkDaoImpl implements Dao<Mark> {

    private DatabaseConnector databaseConnector = new DatabaseConnector();
    private PreparedStatement preparedStatement;

    @Override
    public Mark getById(int id) {
        ResultSet resultSet;
        Mark mark = new Mark();
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("select * from mark where id = ?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mark.setId(resultSet.getInt(1));
                mark.setName(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return mark;
    }

    @Override
    public List<Mark> getAll() {
        List<Mark> marks = new ArrayList<>();
        Mark mark;
        ResultSet resultSet;
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("select * from mark;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                mark = new Mark();
                mark.setId(resultSet.getInt(1));
                mark.setName(resultSet.getString(2));
                marks.add(mark);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return marks;
    }

    @Override
    public boolean create(Mark mark) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement
                    ("insert into mark (id, mark_name) values(?, ?);");
            preparedStatement.setInt(1, mark.getId());
            preparedStatement.setString(2, mark.getName());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            databaseConnector.closeConnection();
        }
    }

    @Override
    public Mark update(Mark mark) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("update mark set mark_name = ? where id = ?;");
            preparedStatement.setInt(2, mark.getId());
            preparedStatement.setString(1, mark.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return mark;
    }

    @Override
    public boolean deleteById(int id) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("delete from mark where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        } finally {
            databaseConnector.closeConnection();
        }
    }
}

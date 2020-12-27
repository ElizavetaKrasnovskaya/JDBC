package com.epam.example.jdbc.dao.impl;

import com.epam.example.jdbc.dao.Dao;
import com.epam.example.jdbc.model.Bus;
import com.epam.example.jdbc.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BusDaoImpl implements Dao<Bus> {

    private final DatabaseConnector databaseConnector = new DatabaseConnector();
    private PreparedStatement preparedStatement;

    @Override
    public Bus getById(int id) {
        ResultSet resultSet;
        Bus bus = new Bus();
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("select * from bus where id = ?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bus.setId(resultSet.getInt(1));
                bus.setNumber(resultSet.getString(2));
                bus.setIssueYear(resultSet.getInt(3));
                bus.setMarkId(resultSet.getInt(4));
                bus.setColorId(resultSet.getInt(5));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return bus;
    }

    @Override
    public List<Bus> getAll() {
        List<Bus> buses = new ArrayList<>();
        ResultSet resultSet;
        Bus bus;
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("select * from bus;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bus = new Bus();
                bus.setId(resultSet.getInt(1));
                bus.setNumber(resultSet.getString(2));
                bus.setIssueYear(resultSet.getInt(3));
                bus.setMarkId(resultSet.getInt(4));
                bus.setColorId(resultSet.getInt(5));
                buses.add(bus);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return buses;
    }

    @Override
    public boolean create(Bus bus) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement
                    ("insert into bus (id, bus_number, issue_year, mark_id, color_id) values(?,?,?,?,?);");
            preparedStatement.setInt(1, bus.getId());
            preparedStatement.setString(2, bus.getNumber());
            preparedStatement.setInt(3, bus.getIssueYear());
            preparedStatement.setInt(4, bus.getMarkId());
            preparedStatement.setInt(5, bus.getColorId());
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
    public Bus update(Bus bus) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("update bus set bus_number=?, issue_year=? where id=?;");
            preparedStatement.setInt(3, bus.getId());
            preparedStatement.setString(1, bus.getNumber());
            preparedStatement.setInt(2, bus.getIssueYear());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return bus;
    }

    @Override
    public boolean deleteById(int id) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("delete from bus where id = ?;");
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

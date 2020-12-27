package com.epam.example.jdbc.dao.impl;

import com.epam.example.jdbc.dao.Dao;
import com.epam.example.jdbc.model.Color;
import com.epam.example.jdbc.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDaoImpl implements Dao<Color> {

    private DatabaseConnector databaseConnector = new DatabaseConnector();
    private PreparedStatement preparedStatement;

    @Override
    public Color getById(int id) {
        Color color = new Color();
        ResultSet resultSet;
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("select * from color where id = ?;");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                color.setId(resultSet.getInt(1));
                color.setName(resultSet.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return color;
    }

    @Override
    public List<Color> getAll() {
        List<Color> colors = new ArrayList<>();
        ResultSet resultSet;
        Color color;
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("select * from color;");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                color = new Color();
                color.setId(resultSet.getInt(1));
                color.setName(resultSet.getString(2));
                colors.add(color);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return colors;
    }

    @Override
    public boolean create(Color color) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement
                    ("insert into color (id, name_of_color) values(?,?);");
            preparedStatement.setInt(1, color.getId());
            preparedStatement.setString(2, color.getName());
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
    public Color update(Color color) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("update color set name_of_color = ? where id =?;");
            preparedStatement.setInt(2, color.getId());
            preparedStatement.setString(1, color.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
        return color;
    }

    @Override
    public boolean deleteById(int id) {
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("delete from color where id = ?;");
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

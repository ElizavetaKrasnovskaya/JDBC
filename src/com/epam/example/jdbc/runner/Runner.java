package com.epam.example.jdbc.runner;

import com.epam.example.jdbc.model.Color;
import com.epam.example.jdbc.util.DatabaseConnector;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Runner {

    public static void main(String[] args) {
        PreparedStatement preparedStatement = null;
        DatabaseConnector databaseConnector = new DatabaseConnector();
        databaseConnector.startConnection();
        try {
            preparedStatement = DatabaseConnector.getConnection().prepareStatement("select * from color;");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<Color> colors = new ArrayList<>();
            while(resultSet.next()){
                int id = resultSet.getInt(1);
                String color = resultSet.getString(2);
                colors.add(new Color(id, color));
            }
            if(colors.size()>0){
                System.out.println(colors);
            }else{
                System.out.println("Not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            databaseConnector.closeConnection();
        }
    }
}

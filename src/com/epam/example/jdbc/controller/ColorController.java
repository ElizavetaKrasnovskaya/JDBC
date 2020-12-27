package com.epam.example.jdbc.controller;

import com.epam.example.jdbc.model.Color;
import com.epam.example.jdbc.service.Service;
import com.epam.example.jdbc.service.impl.ColorServiceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ColorController {

    private Service<Color> service = new ColorServiceImpl();
    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1, 2, 3, 4, 5 or 6");
            System.out.println("1 - print all colors");
            System.out.println("2 - add new color");
            System.out.println("3 - print information about color by id:");
            System.out.println("4 - delete color by id:");
            System.out.println("5 - update color");
            System.out.println("6 - exit");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception ex) {
            }
            if (choice >= 1 & choice <= 6) {
                if (choice == 6) {
                    break;
                }
                switch (choice) {
                    case 1:
                        printAllColors();
                        break;
                    case 2:
                        addNewColor();
                        break;
                    case 3:
                        printById();
                        break;
                    case 4:
                        deleteColor();
                        break;
                    case 5:
                        updateColor();
                        break;
                    default:
                        System.out.println("No information");
                }
            }
        }
    }

    public void printAllColors() {
        for (int i = 0; i < service.getAll().size(); i++) {
            System.out.println(service.getAll().get(i));
        }
    }

    public void addNewColor() {
        Color color = new Color();

        color.setId(fetchInt());
        color.setName(fetchName());

        service.create(color);

        System.out.println("Color created: " + color);
    }

    public void printById() {
        System.out.println(service.getById(fetchInt()));
    }

    public void deleteColor() {
        service.deleteById(fetchInt());
        System.out.println("Mark deleted");
    }

    public void updateColor() {
        int id = fetchInt();
        Color color = service.getById(id);
        color.setName(fetchName());
        service.update(color);
        System.out.println("Color updated: " + color);
    }


    public int fetchInt() {
        scanner = new Scanner(System.in);
        int id = 0;
        while (true) {
            System.out.println("Enter id: ");
            try {
                id = Integer.parseInt(scanner.next());
            } catch (Exception ex) {
            }
            if (id > 0) {
                return id;
            }
        }
    }

    public String fetchName() {
        scanner = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("Enter name:");
            name = scanner.next();
            if (name.length() <= 20 & Pattern.matches("[a-zA-Z]+", name) == true) {
                return name;
            }
        }
    }

}

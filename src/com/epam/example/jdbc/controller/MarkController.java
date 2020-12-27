package com.epam.example.jdbc.controller;

import com.epam.example.jdbc.model.Mark;
import com.epam.example.jdbc.service.Service;
import com.epam.example.jdbc.service.impl.MarkServiceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class MarkController {

    private final Service<Mark> service = new MarkServiceImpl();

    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1, 2, 3, 4, 5 or 6");
            System.out.println("1 - print all marks");
            System.out.println("2 - add new mark");
            System.out.println("3 - print information about mark by id:");
            System.out.println("4 - delete mark by id:");
            System.out.println("5 - update mark");
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
                        printAllMarks();
                        break;
                    case 2:
                        addNewMark();
                        break;
                    case 3:
                        printById();
                        break;
                    case 4:
                        deleteMark();
                        break;
                    case 5:
                        updateMark();
                        break;
                    default:
                        System.out.println("No information");
                }
            }
        }
    }

    public void printAllMarks() {
        for (int i = 0; i < service.getAll().size(); i++) {
            System.out.println(service.getAll().get(i));
        }
    }

    public void addNewMark() {
        Mark mark = new Mark();

        mark.setId(fetchInt());
        mark.setName(fetchName());

        service.create(mark);

        System.out.println("Mark created: " + mark);
    }

    public void printById() {
        System.out.println(service.getById(fetchInt()));
    }

    public void deleteMark() {
        service.deleteById(fetchInt());
        System.out.println("Mark deleted");
    }

    public void updateMark() {
        int id = fetchInt();
        Mark mark = service.getById(id);
        mark.setName(fetchName());
        service.update(mark);
        System.out.println("Mark updated: " + mark);
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

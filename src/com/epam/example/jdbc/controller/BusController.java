package com.epam.example.jdbc.controller;

import com.epam.example.jdbc.model.Bus;
import com.epam.example.jdbc.service.Service;
import com.epam.example.jdbc.service.impl.BusServiceImpl;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BusController {

    private Service<Bus> service = new BusServiceImpl();
    private Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1, 2, 3, 4, 5 or 6");
            System.out.println("1 - print all buses");
            System.out.println("2 - add new bus");
            System.out.println("3 - print information about bus by id:");
            System.out.println("4 - delete bus by id:");
            System.out.println("5 - update bus");
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
                        printAllBuses();
                        break;
                    case 2:
                        addNewBus();
                        break;
                    case 3:
                        printById();
                        break;
                    case 4:
                        deleteBus();
                        break;
                    case 5:
                        updateBus();
                        break;
                    default:
                        System.out.println("No information");
                }
            }
        }
    }

    public void printAllBuses() {
        for (int i = 0; i < service.getAll().size(); i++) {
            System.out.println(service.getAll().get(i));
        }
    }

    public void addNewBus() {
        Bus bus = new Bus();

        bus.setId(fetchInt());
        bus.setNumber(fetchNumber());
        bus.setIssueYear(fetchYear());
        bus.setMarkId(fetchInt());
        bus.setColorId(fetchInt());

        service.create(bus);

        System.out.println("Bus created: " + bus);
    }

    public void printById() {
        System.out.println(service.getById(fetchInt()));
    }

    public void deleteBus() {
        service.deleteById(fetchInt());
        System.out.println("Bus deleted");
    }

    public void updateBus() {
        int id = fetchInt();
        Bus bus = service.getById(id);
        bus.setNumber(fetchNumber());
        bus.setIssueYear(fetchYear());
        service.update(bus);
        System.out.println("Bus updated: " + bus);
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

    public String fetchNumber() {
        scanner = new Scanner(System.in);
        String number = new String();
        while (true) {
            System.out.println("Enter number of bus: ");
            try {
                number = scanner.next();
            } catch (Exception ex) {
            }
            if (number.length() == 4) {
                return number;
            }
        }
    }

    public int fetchYear() {
        scanner = new Scanner(System.in);
        int year = 0;
        while (true) {
            System.out.println("Enter issue year: ");
            try {
                year = Integer.parseInt(scanner.next());
            } catch (Exception ex) {
            }
            if (year >= 1980 && year <= 2021) {
                return year;
            }
        }
    }

}

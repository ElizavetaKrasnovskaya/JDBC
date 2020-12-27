package com.epam.example.jdbc.controller;

import java.util.Scanner;

public class RunnerController {

    private final BusController busController = new BusController();
    private final ColorController colorController = new ColorController();
    private final MarkController markController = new MarkController();

    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter 1, 2, 3 or 4");
            System.out.println("1 - Color");
            System.out.println("2 - Mark");
            System.out.println("3 - Bus");
            System.out.println("4 - exit");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.next());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (choice >= 1 && choice <= 4) {
                if (choice == 4) {
                    break;
                }
                switch (choice) {
                    case 1:
                        colorController.start();
                        break;
                    case 2:
                        markController.start();
                        break;
                    case 3:
                        busController.start();
                        break;
                    default:
                        System.out.println("No information");
                }
            }
        }
    }
}

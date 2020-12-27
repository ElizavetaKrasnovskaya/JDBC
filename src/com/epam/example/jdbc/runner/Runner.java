package com.epam.example.jdbc.runner;

import com.epam.example.jdbc.controller.RunnerController;

public class Runner {

    public static void main(String[] args) {
        RunnerController runnerController = new RunnerController();
        runnerController.menu();
    }
}

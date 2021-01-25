package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.adapter.controllers.AtmSimulationController;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.exceptions.InsufficientBalanceException;

import java.util.Scanner;

public class WithdrawScreen {
    public static void run(Account account, AtmSimulationController atmSimulationController) {
        boolean isExitSelected = false;
        Scanner in = new Scanner(System.in);
        while (!isExitSelected) {
            printWithdrawMenu();
            String selectedMenu = in.nextLine();
            switch (selectedMenu) {
                case "1":
                    try {
                        atmSimulationController.withdraw(200, account, false);
                    } catch (InsufficientBalanceException ib) {
                        System.out.println(ib.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Fund Transfer");
                    break;
                case "3":
                    System.out.println("Exit");
                    isExitSelected = true;
                    break;
                case "":
                    System.out.println("Not Selecting Menu");
                    isExitSelected = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void printWithdrawMenu() {
        System.out.print("1. $10\n" +
                "2. $50\n" +
                "3. $100\n" +
                "4. Other\n" +
                "5. Back\n" +
                "Please choose option[5]: ");
    }
}

package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.adapter.controllers.AtmSimulationController;
import main.java.com.mitrais.studycase.domain.entities.Account;

import java.util.Scanner;

public class TransactionScreen {
    public static void run(Account account, AtmSimulationController atmSimulationController) {
        boolean isExitSelected = false;
        Scanner in = new Scanner(System.in);
        while (!isExitSelected) {
            printTransactionMenu();
            String selectedMenu = in.nextLine();
            switch (selectedMenu) {
                case "1":
                    isExitSelected = WithdrawScreen.run(account, atmSimulationController);
                    break;
                case "2":
                    System.out.println("Fund Transfer");
                    break;
                case "3":
                case "":
                    isExitSelected = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void printTransactionMenu() {
        System.out.print("" +
                "1. Withdraw\n" +
                "2. Fund Transfer\n" +
                "3. Exit\n" +
                "Please choose option[3]: ");
    }
}

package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.domain.entities.Account;

import java.util.Scanner;

public class TransactionScreen {
    public static void run(Account account) {
        boolean isExitSelected = false;
        Scanner in = new Scanner(System.in);
        while (!isExitSelected){
            printTransactionMenu();
            String selectedMenu = in.nextLine();
            switch (selectedMenu){
                case "1":
                    System.out.println("Withdraw");
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

    private static void printTransactionMenu() {
        System.out.print("" +
                "1. Withdraw\n" +
                "2. Fund Transfer\n" +
                "3. Exit\n" +
                "Please choose option[3]: ");
    }
}

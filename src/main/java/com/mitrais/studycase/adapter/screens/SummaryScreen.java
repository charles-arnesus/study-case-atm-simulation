package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.domain.entities.Account;

import java.util.Scanner;

public class SummaryScreen {
    public static boolean run(Account account, int withdrawAmount) {
        boolean isExitSelected = false, isBackToWelcomeScreen = false;
        Scanner in = new Scanner(System.in);
        while (!isExitSelected) {
            printSummaryMenu(withdrawAmount, account.getBalance());
            String selectedMenu = in.nextLine();
            switch (selectedMenu) {
                case "1":
                    isBackToWelcomeScreen = false;
                    isExitSelected = true;
                    break;
                case "2":
                case "":
                    isBackToWelcomeScreen = true;
                    isExitSelected = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
        return isBackToWelcomeScreen;
    }

    private static void printSummaryMenu(int withdrawAmount, int balance) {
        String menu = String.format("SummaryDate : 2019-02-30 10:00 AM\n" +
                "Withdraw : $%d\n" +
                "Balance : $%d\n" +
                "\n1. Transaction\n" +
                "2. Exit\n" +
                "Choose option[2]: ", withdrawAmount, balance);
        System.out.print(menu);
    }
}

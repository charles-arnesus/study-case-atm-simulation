package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.domain.entities.Account;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SummaryScreen {
    public static boolean run(Account account, int withdrawAmount) {
        boolean isExitSelected = false, isBackToWelcomeScreen = false;
        Scanner in = new Scanner(System.in);
        String selectedMenu;
        while (!isExitSelected) {
            printSummaryMenu(withdrawAmount, account.getBalance());
            selectedMenu = in.nextLine();
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd h:m a");
        String now = LocalDateTime.now().format(formatter);
        String menu = String.format("SummaryDate : %s\n" +
                "Withdraw : $%d\n" +
                "Balance : $%d\n" +
                "\n1. Transaction\n" +
                "2. Exit\n" +
                "Choose option[2]: ", now, withdrawAmount, balance);
        System.out.print(menu);
    }
}

package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.adapter.controllers.AtmSimulationController;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.exceptions.InsufficientBalanceException;

import java.util.Scanner;

public class WithdrawScreen {
    public static boolean run(Account account, AtmSimulationController atmSimulationController) {
        boolean isExitSelected = false, isBackToWelcomeScreen = false;
        Scanner in = new Scanner(System.in);
        int withdrawAmount = 0;
        String selectedMenu;
        boolean isFromOtherWithdrawScreen = false, isValidOption = true;
        while (!isExitSelected) {
            printWithdrawMenu();
            selectedMenu = in.nextLine();
            switch (selectedMenu) {
                case "1":
                    withdrawAmount = 10;
                    isFromOtherWithdrawScreen = false;
                    isValidOption = true;
                    break;
                case "2":
                    withdrawAmount = 50;
                    isFromOtherWithdrawScreen = false;
                    isValidOption = true;
                    break;
                case "3":
                    withdrawAmount = 100;
                    isFromOtherWithdrawScreen = false;
                    isValidOption = true;
                    break;
                case "4":
                    isFromOtherWithdrawScreen = true;
                    isValidOption = true;
                    break;
                case "5":
                case "":
                    isExitSelected = true;
                    break;
                default:
                    isValidOption = false;
                    System.out.println("Invalid option");
                    break;
            }
            if(!isExitSelected && isValidOption) {
                try {
                    if (isFromOtherWithdrawScreen) {
                        isBackToWelcomeScreen = OtherWithdrawScreen.run(account, atmSimulationController);
                    } else {
                        Account deductedAccount = atmSimulationController.withdraw(withdrawAmount, account, false);
                        isBackToWelcomeScreen = SummaryScreen.run(deductedAccount, withdrawAmount);
                    }
                    isExitSelected = true;
                } catch (InsufficientBalanceException ib) {
                    System.out.println(ib.getMessage());
                }
            }
        }
        return isBackToWelcomeScreen;
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

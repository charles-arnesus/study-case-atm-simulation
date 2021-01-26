package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.adapter.controllers.AtmSimulationController;
import main.java.com.mitrais.studycase.common.constants.Constants;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.exceptions.InsufficientBalanceException;

import java.util.Scanner;

public class OtherWithdrawScreen {
    public static boolean run(Account account, AtmSimulationController atmSimulationController) {
        boolean isExitSelected = false, isBackToWelcomeScreen = false;
        Scanner in = new Scanner(System.in);
        int withdrawAmount;
        String withdrawAmountStr;
        while (!isExitSelected) {
            printOtherWithdrawMenu();
            withdrawAmountStr = in.nextLine();
            if (!withdrawAmountStr.matches(Constants.REGEX)) {
                System.out.println("Invalid Amount");
            } else {
                withdrawAmount = Integer.parseInt(withdrawAmountStr);
                if (withdrawAmount > 1000 ) {
                    System.out.println("Maximum amount to withdraw is $1000");
                } else if (withdrawAmount % 10 != 0) {
                    System.out.println("Invalid Amount");
                } else {
                    try {
                        Account deductedAccount = atmSimulationController.withdraw(withdrawAmount, account, true);
                        isBackToWelcomeScreen = SummaryScreen.run(deductedAccount, withdrawAmount);
                        isExitSelected = true;
                    } catch (InsufficientBalanceException ib) {
                        System.out.println(ib.getMessage());
                    }
                }
            }
        }
        return isBackToWelcomeScreen;
    }

    private static void printOtherWithdrawMenu() {
        System.out.print("Other Withdraw\n" +
                "Enter amount to withdraw: ");
    }
}

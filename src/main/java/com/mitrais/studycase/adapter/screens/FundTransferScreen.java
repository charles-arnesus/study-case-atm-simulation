package main.java.com.mitrais.studycase.adapter.screens;

import main.java.com.mitrais.studycase.adapter.controllers.AtmSimulationController;
import main.java.com.mitrais.studycase.common.constants.Constants;
import main.java.com.mitrais.studycase.domain.entities.Account;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class FundTransferScreen {
    public static boolean run(Account account, AtmSimulationController atmSimulationController) {
        final int min = 100000;
        final int max = 999999;
        boolean isExitSelected = false, isBackToWelcomeScreen = false, isConfirmed = false, isTransferAmountValid = false;
        boolean isAccountValid;
        int referenceNumber, transferAmountInt;
        Scanner in = new Scanner(System.in);
        String accountDestination, transferAmount, confirmation;
        while (!isExitSelected) {
            printAccountDestinationMenu();
            accountDestination = in.nextLine();
            if (accountDestination.isEmpty()) {
                isExitSelected = true;
            }
            if (!isExitSelected) {
                isAccountValid = validateAccountDestination(accountDestination,
                        atmSimulationController);
                if (isAccountValid) {
                    while (!isTransferAmountValid) {
                        printTransferAmountMenu();
                        transferAmount = in.nextLine();
                        if (transferAmount.isEmpty()) {
                            isTransferAmountValid = true;
                            isExitSelected = true;
                        }
                        if (!isExitSelected) {
                            isTransferAmountValid = validateTransferAmount(transferAmount, account);
                            if (isTransferAmountValid) {
                                transferAmountInt = Integer.parseInt(transferAmount);
                                referenceNumber = ThreadLocalRandom.current().nextInt(min, max);
                                printReferenceNumberMenu(referenceNumber);
                                in.nextLine();
                                while (!isConfirmed) {
                                    printConfirmationMenu(accountDestination, transferAmountInt, referenceNumber);
                                    confirmation = in.nextLine();
                                    switch (confirmation) {
                                        case "1":
                                            Account result = atmSimulationController.transferFund(
                                                    account.getAccountNumber(),
                                                    accountDestination,
                                                    transferAmountInt);
                                            printSummaryMenu(accountDestination,
                                                    transferAmount,
                                                    referenceNumber,
                                                    result.getBalance());
                                            confirmation = in.nextLine();
                                            if (confirmation.equals("2")) {
                                                isBackToWelcomeScreen = true;
                                            }
                                            isConfirmed = true;
                                            isExitSelected = true;
                                            break;
                                        case "2":
                                        case "":
                                            isExitSelected = true;
                                            isConfirmed = true;
                                            break;
                                        default:
                                            System.out.println("Invalid option");
                                            isConfirmed = false;
                                            break;
                                    }
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid Account");
                }
            }
        }
        return isBackToWelcomeScreen;
    }

    private static boolean validateTransferAmount(String transferAmount, Account account) {
        if (!transferAmount.matches(Constants.REGEX)) {
            System.out.println("Invalid amount");
            return false;
        }
        int transferAmountInt = Integer.parseInt(transferAmount);
        if (transferAmountInt > 1000) {
            System.out.println("Maximum amount to withdraw is $1000");
            return false;
        } else if (transferAmountInt < 1) {
            System.out.println("Minimum amount to withdraw is $1");
            return false;
        } else if (transferAmountInt > account.getBalance()) {
            System.out.println("Insufficient balance $" + transferAmountInt);
            return false;
        }
        return true;
    }

    private static boolean validateAccountDestination(String accountDestination,
                                                      AtmSimulationController atmSimulationController) {
        if (!accountDestination.matches(Constants.REGEX)) {
            return false;
        }
        Account result = atmSimulationController.findAccount(accountDestination);
        return result != null;
    }

    private static void printAccountDestinationMenu() {
        System.out.print("Please enter destination account and press enter to continue or\n" +
                "press enter to go back to Transaction: ");
    }

    private static void printTransferAmountMenu() {
        System.out.print("Please enter transfer amount and\n" +
                "press enter to continue or\n" +
                "press enter to go back to Transaction: ");
    }

    private static void printReferenceNumberMenu(int referenceNumber) {
        System.out.print("Reference Number: " +
                        referenceNumber +
                "\npress enter to continue");
    }

    private static void printConfirmationMenu(String accountDestination, int transferAmount, int referenceNumber) {
        System.out.print("Transfer Confirmation" +
                "\nDestination Account : " + accountDestination +
                "\nTransfer Amount     : $" + transferAmount +
                "\nReference Number    : " + referenceNumber +
                "\n\n1. Confirm Trx" +
                "\n2. Cancel Trx" +
                "\nChoose option[2]:");
    }

    private static void printSummaryMenu(String accountDestination, String transferAmount, int referenceNumber, int balance) {
        System.out.print("Fund Transfer Summar" +
                "\nDestination Account : " + accountDestination +
                "\nTransfer Amount     : $" + transferAmount +
                "\nReference Number    : " + referenceNumber +
                "\nBalance             : $" + balance +
                "\n\n1. Transaction" +
                "\n2. Exit" +
                "\nChoose option[2]:");
    }
}

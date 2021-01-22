package main.java.com.mitrais.studycase.domain.entities;

import java.util.Objects;

public class Account {
    private String name;
    private String pin;
    private String balance;
    private String accountNumber;

    public Account(String name, String pin, String balance, String accountNumber) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;
        Account account = (Account) o;
        return Objects.equals(getName(), account.getName()) &&
                Objects.equals(getPin(), account.getPin()) &&
                Objects.equals(getBalance(), account.getBalance()) &&
                Objects.equals(getAccountNumber(), account.getAccountNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPin(), getBalance(), getAccountNumber());
    }
}

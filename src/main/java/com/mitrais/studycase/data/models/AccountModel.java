package main.java.com.mitrais.studycase.data.models;

import main.java.com.mitrais.studycase.domain.entities.Account;

public class AccountModel extends Account {

    public AccountModel(String name, String pin, String balance, String accountNumber) {
        super(name, pin, balance, accountNumber);
    }
}

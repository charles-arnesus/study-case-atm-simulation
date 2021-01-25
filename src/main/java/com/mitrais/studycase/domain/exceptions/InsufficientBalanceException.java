package main.java.com.mitrais.studycase.domain.exceptions;

import main.java.com.mitrais.studycase.domain.entities.Account;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

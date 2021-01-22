package main.java.com.mitrais.studycase.domain.repositories;

import main.java.com.mitrais.studycase.domain.entities.Account;

public interface AtmSimulationRepository {
    Account signIn(String testAccountNumber, String testPin);
}

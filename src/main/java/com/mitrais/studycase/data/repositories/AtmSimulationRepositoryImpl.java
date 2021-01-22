package main.java.com.mitrais.studycase.data.repositories;

import main.java.com.mitrais.studycase.data.datasources.AtmSimulationDataSource;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.repositories.AtmSimulationRepository;

public class AtmSimulationRepositoryImpl implements AtmSimulationRepository {
    private final AtmSimulationDataSource atmSimulationDataSource;

    public AtmSimulationRepositoryImpl(AtmSimulationDataSource atmSimulationDataSource) {
        this.atmSimulationDataSource = atmSimulationDataSource;
    }

    @Override
    public Account signIn(String testAccountNumber, String testPin) {
        return atmSimulationDataSource.signIn(testAccountNumber, testPin);
    }
}

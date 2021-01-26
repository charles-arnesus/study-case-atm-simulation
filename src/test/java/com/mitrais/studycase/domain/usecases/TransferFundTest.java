package test.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.data.datasources.AtmSimulationDataSourceImpl;
import main.java.com.mitrais.studycase.data.repositories.AtmSimulationRepositoryImpl;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.usecases.TransferFund;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TransferFundTest {
    private final AtmSimulationDataSourceImpl atmSimulationDataSource = new AtmSimulationDataSourceImpl();
    private final AtmSimulationRepositoryImpl atmSimulationRepository = new AtmSimulationRepositoryImpl(atmSimulationDataSource);
    private final TransferFund useCase = new TransferFund(atmSimulationRepository);

    @Test
    public void testShouldSuccessfullyTransferFundFromOneAccountToAnother() {
        final Account testSourceAccount = new Account("John Doe", "012108", 90, "112233");
        final Account testDestinationAccount = new Account("Jane Doe", "932012", 40, "112244");
        final int transferAmount = 10;
        final Account result = useCase.transferFund(testSourceAccount.getAccountNumber(),
                testDestinationAccount.getAccountNumber(),
                transferAmount);
        assertEquals(testSourceAccount, result);
    }
}

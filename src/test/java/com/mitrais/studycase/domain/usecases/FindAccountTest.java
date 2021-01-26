package test.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.data.datasources.AtmSimulationDataSourceImpl;
import main.java.com.mitrais.studycase.data.repositories.AtmSimulationRepositoryImpl;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.usecases.FindAccount;
import main.java.com.mitrais.studycase.domain.usecases.Withdraw;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FindAccountTest {
    private final AtmSimulationDataSourceImpl atmSimulationDataSource = new AtmSimulationDataSourceImpl();
    private final AtmSimulationRepositoryImpl atmSimulationRepository = new AtmSimulationRepositoryImpl(atmSimulationDataSource);
    private final FindAccount useCase = new FindAccount(atmSimulationRepository);

    @Test
    public void testShouldReturnAccountWhenAccountIsExist() {
        final Account testAccount = new Account("John Doe", "012108", 100, "112233");
        final String testAccountNumber = "112233";
        final Account result = useCase.findAccount(testAccountNumber);
        assertEquals(testAccount, result);
    }

    @Test
    public void testShouldReturnNullWhenAccountIsNotExist() {
        final String testAccountNumber = "123456";
        final Account result = useCase.findAccount(testAccountNumber);
        assertNull(result);
    }
}

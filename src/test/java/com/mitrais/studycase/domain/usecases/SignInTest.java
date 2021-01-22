package test.java.com.mitrais.studycase.domain.usecases;

import main.java.com.mitrais.studycase.data.datasources.AtmSimulationDataSourceImpl;
import main.java.com.mitrais.studycase.data.repositories.AtmSimulationRepositoryImpl;
import main.java.com.mitrais.studycase.domain.entities.Account;
import main.java.com.mitrais.studycase.domain.usecases.SignIn;
import org.junit.Test;
import static org.junit.Assert.*;

public class SignInTest {
    private final AtmSimulationDataSourceImpl atmSimulationDataSource = new AtmSimulationDataSourceImpl();
    private final AtmSimulationRepositoryImpl atmSimulationRepository = new AtmSimulationRepositoryImpl(atmSimulationDataSource);
    private final SignIn useCase = new SignIn(atmSimulationRepository);

    @Test
    public void testShouldReturnTrueWhenSignInUsingCorrectAccountAndPin() {
        final Account testAccount = new Account("John Doe", "012108", "$100", "112233");
        final String testAccountNumber = "112233";
        final String testPin = "012108";
        final Account result = useCase.signIn(testAccountNumber, testPin);
        assertEquals(testAccount, result);
    }
}

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccParameterResolver.class)
@DisplayName("Repeat Test")
public class BankAccountRepeatedTestTest {
    @RepeatedTest(5)
    @DisplayName("Withdraws 500 from Bank acc")
    public void testDeposit(BankAccount bankAccount, RepetitionInfo repetitionInfo){
        bankAccount.deposit(500);
        Assertions.assertEquals(500,bankAccount.getBalance());
        System.out.println("Nr: "+repetitionInfo.getCurrentRepetition());
    }
}

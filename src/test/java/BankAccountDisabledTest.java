import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccParameterResolver.class)
public class BankAccountDisabledTest {
    @Test
    @Disabled
    @DisplayName("Withdraws 500 from Bank acc")
    public void testDeposit(BankAccount bankAccount){
        bankAccount.deposit(500);
        Assertions.assertEquals(500,bankAccount.getBalance());
    }
}

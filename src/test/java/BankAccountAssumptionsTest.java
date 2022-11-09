import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountAssumptionsTest {

    @Test
    @DisplayName("Test if bank acc is active")
    public void testActive(){
        BankAccount bankAccount = new BankAccount(500, -1000);
//      Assumptions.assumeTrue(bankAccount == null, "bank acc is not available");
//      Assertions.assertTrue(bankAccount.isActive());
        Assumptions.assumingThat(bankAccount == null, () ->  Assertions.assertTrue(bankAccount.isActive()));

    }
}

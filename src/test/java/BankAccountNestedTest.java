import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BankAccountNestedTest {
    @Test
    @DisplayName("Withdraws 500 from Bank acc")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(700,0);
        bankAccount.withdraw(500);
        Assertions.assertEquals(200,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposits 500 from Bank acc")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(0,0);
        bankAccount.deposit(500);
        Assertions.assertEquals(500,bankAccount.getBalance());
    }

    @Nested
    class WhenBalanceEqualsZero{
        @Test
        @DisplayName("test withdraw when min bal is 0")
        public void testWithdrawMinBalIs0(){
            BankAccount bankAccount = new BankAccount(0,0);
            Assertions.assertThrows(RuntimeException.class, () -> bankAccount.withdraw(500));
        }

        @Test
        @DisplayName("Test Withdraw when Min Bal is -1000")
        public void testWithdrawMinBalIsNeg1000(){
            BankAccount bankAccount = new BankAccount(0,-1000);
            bankAccount.withdraw(500);
            Assertions.assertEquals(-500, bankAccount.getBalance());
        }
    }
}

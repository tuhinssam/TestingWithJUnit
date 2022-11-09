import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@DisplayName("Test BankAccount Class")
public class BankAccountTest {

    @Test
    @DisplayName("Withdraw 100 successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(1000, 200);
        bankAccount.withdraw(100);
        Assertions.assertEquals(900,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 200 successfully")
    public void testDeposit(){
       BankAccount bankAccount = new BankAccount(1000, 200);
       bankAccount.deposit(200);
       Assertions.assertEquals(1200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("withdraw will become negative")
    public void testWithdrawNotStuckToZero(){
        BankAccount bankAccount = new BankAccount(1000, -1000);
        bankAccount.withdraw(1800);
        Assertions.assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Test if Bank Account is active after creation")
    public void testIsBankAccActive(){
        BankAccount bankAccount = new BankAccount(100, -100);
        Assertions.assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Account Holder Name set")
    public void testHolderNameSet(){
        BankAccount bankAccount = new BankAccount(1000, -1000);
        bankAccount.setAccountHolder("tuhin");
        Assertions.assertNotNull(bankAccount.getAccountHolder());
    }

    @Test
    @DisplayName("Test No withdraw after minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        Assertions.assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000), "Oops! trying to withdraw more than allowed limit!");
    }

    @Test
    @DisplayName("'Test no exception for deposit and withdraw")
    public void testDepositWithdrawWithoutException(){
        BankAccount bankAccount = new BankAccount(1000, -1000);
        Assertions.assertAll(() -> bankAccount.deposit(100), () -> bankAccount.withdraw(500));
    }

    @Test
    @DisplayName("Test Speed Deposit")
    public void testSpeedDeposit(){
        BankAccount bankAccount = new BankAccount(1000, -1000);
        Assertions.assertTimeout(Duration.ofNanos(1), ()-> bankAccount.deposit(100));
    }
}

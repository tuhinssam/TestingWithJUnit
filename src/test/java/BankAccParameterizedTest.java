import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.DayOfWeek;

@ExtendWith(BankAccParameterResolver.class)
public class BankAccParameterizedTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 400, 500, 800})
    @DisplayName("Withdraws 500 from Bank acc")
    public void testDeposit(int amount,BankAccount bankAccount){
        bankAccount.deposit(amount);
        Assertions.assertEquals(amount,bankAccount.getBalance());
    }

    @ParameterizedTest
    @EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
    public void testDayOfWeek(DayOfWeek day){
        Assertions.assertTrue(day.toString().startsWith("T"));
    }

    @ParameterizedTest
    @CsvSource({"100, Tom","200, Rick", "300, Harry"})
    public void depositAndNameTest(double amount, String name, BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setAccountHolder(name);
        Assertions.assertEquals(amount, bankAccount.getBalance());
        Assertions.assertEquals(name, bankAccount.getAccountHolder());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "details.csv")
    public void depositAndNameTestUsingCsv(double amount, String name, BankAccount bankAccount){
        bankAccount.deposit(amount);
        bankAccount.setAccountHolder(name);
        Assertions.assertEquals(amount, bankAccount.getBalance());
        Assertions.assertEquals(name, bankAccount.getAccountHolder());
    }
}

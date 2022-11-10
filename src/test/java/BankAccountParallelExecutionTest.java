import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.CONCURRENT)
@ExtendWith(BankAccParameterResolver.class)
public class BankAccountParallelExecutionTest {

    @Test
    @DisplayName("Withdraws 500 from Bank acc")
    public void testDeposit1(BankAccount bankAccount) {
        try{
            Thread.sleep(400);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraws 500 from Bank acc")
    public void testDeposit2(BankAccount bankAccount) {
        try{
            Thread.sleep(1200);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Withdraws 500 from Bank acc")
    public void testDeposit3(BankAccount bankAccount) {
        try{
            Thread.sleep(1500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        bankAccount.deposit(500);
        Assertions.assertEquals(500, bankAccount.getBalance());
    }
}
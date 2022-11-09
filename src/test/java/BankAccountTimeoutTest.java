import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@ExtendWith(BankAccParameterResolver.class)
public class BankAccountTimeoutTest {

    @Test
    @Timeout(value = 500, unit = TimeUnit.MILLISECONDS)
    public void testDepositTimeoutAssertion(BankAccount bankAccount){
       try{
           Thread.sleep(400);
       }catch (InterruptedException e){
           e.printStackTrace();
       }
       bankAccount.deposit(500);
       Assertions.assertEquals(500, bankAccount.getBalance());
    }

    @Test

    public void testDepositTimeoutAnnotation(BankAccount bankAccount){
        try{
            Thread.sleep(400);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        bankAccount.deposit(300);
        Assertions.assertTimeout(Duration.ofMillis(500), () ->{
            Thread.sleep(100);
        });
    }
}

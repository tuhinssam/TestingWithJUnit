import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Enforces Ordered execution of test cases")
public class BankAccOrderedExecTest {

    static BankAccount bankAccount = new BankAccount(0,0);

    @Test
    @Order(2)
    @DisplayName("Withdraws 500 from Bank acc")
    public void testWithdraw(){
        bankAccount.withdraw(500);
        Assertions.assertEquals(0,bankAccount.getBalance());
    }

    @Test
    @Order(1)
    @DisplayName("Deposits 500 from Bank acc")
    public void testDeposit(){
        bankAccount.deposit(500);
        Assertions.assertEquals(500,bankAccount.getBalance());
    }

}

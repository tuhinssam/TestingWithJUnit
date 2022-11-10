import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAfterTest {

    static BankAccount bankAccount;

    @BeforeAll
    public static void prepTest(){
        System.out.println("hi");
        bankAccount = new BankAccount(600,0);
    }

//    @BeforeEach
//    public void prepTest(){
//        System.out.println("Hi!");
//        bankAccount = new BankAccount(600,0);
//    }

    @Test
    @DisplayName("Withdraws 500 from Bank acc")
    public void testWithdraw(){
        bankAccount.withdraw(100);
        Assertions.assertEquals(500,bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposits 500 from Bank acc")
    public void testDeposit(){
        bankAccount.deposit(500);
        Assertions.assertEquals(1000,bankAccount.getBalance());
    }

    @AfterAll
    public static void endTest(){
        System.out.println("End Test");
    }

//    @AfterEach
//    public void endTest(){
//        System.out.println("Bye!");
//    }
}

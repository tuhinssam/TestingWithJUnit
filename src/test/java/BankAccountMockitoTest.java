import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankAccountMockitoTest {
    @Mock
    CalculateMethods calculateMethods;

    @BeforeEach
    public void setupMocks(){
        Mockito.when(calculateMethods.divide(6,3)).thenReturn(2.0);
    }

    @Test
    public void testDivide(){
        Assertions.assertEquals(2.0, calculateMethods.divide(6,3));
    }
}

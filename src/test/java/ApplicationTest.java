import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.example.Application;

public class ApplicationTest {
    @Test
    public void functionTest() {
        int n = Application.functionaTest();
        Assertions.assertEquals(0, n);
    }
}

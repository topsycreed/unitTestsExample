import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
    @Parameters({ "suite-param" })
    @Test
    public void parameterTestOne(String param) {
        System.out.println("Test one suite param is: " + param);
    }

    @Parameters({ "test-two-param" })
    @Test
    public void parameterTestTwo(String param) {
        System.out.println("Test two param is: " + param);
    }

    @Parameters({ "suite-param", "test-three-param" })
    @Test
    public void prameterTestThree(String param, String paramTwo) {
        System.out.println("Test three suite param is: " + param);
        System.out.println("Test three param is: " + paramTwo);
    }

    @Parameters({ "optional-value" })
    @Test
    public void optionTest(@Optional("optional value") String value) {
        System.out.println("This is: " + value);
    }
}

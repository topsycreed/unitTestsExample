import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SecondTest {
    @Test
    public void simpleTest() {
        String str = "TestNG is working fine";
        assertEquals("TestNG is working fine", str);
    }

    @Test(priority = 1, groups = {"smoke", "regression"})
    public void complexTestScenario() {
        System.out.println("Executing a complex test scenario");
    }

    @Test(priority = 2, dataProvider = "dataProviderMethod")
    public void testWithDataProvider(String firstName, String lastName) {
        // Здесь размещаем код теста, использующий переданные параметры
        System.out.println(firstName + " " + lastName);
    }
    @DataProvider
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {"John", "Doe"},
                {"Alice", "Smith"},
                // Дополнительные варианты данных
        };
    }
}

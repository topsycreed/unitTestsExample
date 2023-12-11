import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.productstar.User;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleJUnitTest {

    @Test
    public void first() throws Exception{
        System.out.println("FirstParallelUnitTest first() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest first() end => " + Thread.currentThread().getName());
    }

    @Test
    public void second() throws Exception{
        System.out.println("FirstParallelUnitTest second() start => " + Thread.currentThread().getName());
        Thread.sleep(500);
        System.out.println("FirstParallelUnitTest second() end => " + Thread.currentThread().getName());
    }

    @ParameterizedTest
    @MethodSource("provideParameters")
    void testWithCustomParameters(String parameter) {
        List<String> expectedList = Arrays.asList("one", "two", "three");
        assertTrue(expectedList.contains(parameter.toLowerCase(Locale.ROOT)));
    }

    static Stream<String> provideParameters() {
        return Stream.of("One", "Two", "Three");
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithParameters(int parameter) {
        int actualSum = parameter + parameter;
        int expectedSum = 2 * parameter;
        assertEquals(expectedSum, actualSum, "Суммы должны быть разными");
    }

    @ParameterizedTest
    @CsvSource({"John, Doe", "Alice, Smith"})
    void testWithCsvParameters(String firstName, String lastName) {
        List<String> expectedPeople = Arrays.asList("John Doe1", "Alice Smith");
        assertTrue(expectedPeople.contains(firstName + " " + lastName));
    }

    @Test
    void assertsJUnitTest() {
        User user = new User("John", "Doe", 30);
        assertAll(
                () -> assertEquals("John", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(30, user.getAge(), "Неправильный возраст")
        );
    }

    @Test
    @Tag("smoke")
    @DisplayName("Сумма двух чисел")
    void simpleJUnitTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum, "Суммы должны быть разными");
    }
}

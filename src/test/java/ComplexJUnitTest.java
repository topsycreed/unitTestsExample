import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexJUnitTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void testWithParameters(int parameter) {
        // Здесь размещаем код теста с параметрами
        int actualSum = parameter + parameter;
        int expectedSum = parameter * 2;
        // Используем assertTrue, assertFalse, assertEquals и другие методы Assertions
        assertEquals(expectedSum, actualSum);
    }

    @ParameterizedTest
    @CsvSource({"John, Doe", "Alice, Smith"})
    void testWithCsvParameters(String firstName, String lastName) {
        // Здесь размещаем код теста с параметрами из CSV
        List<String> expectedPeople = Arrays.asList("John Doe1", "Alice Smith");
        assertTrue(expectedPeople.contains(firstName + " " + lastName), String.format("Значение <%s %s> не найдено среди: %s", firstName, lastName, expectedPeople));
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
}

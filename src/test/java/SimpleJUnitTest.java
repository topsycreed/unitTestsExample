import org.junit.jupiter.api.*;
import org.productstar.User;

import static org.junit.jupiter.api.Assertions.*;

@Tag("smoke")//тег всех тестов
public class SimpleJUnitTest {

    @Test
    void simpleJUnitTest() {
        // Здесь размещаем код теста
        int actualSum = 2 + 2;
        int expectedSum = 4;
        // Используем assertTrue, assertFalse, assertEquals и другие методы Assertions
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Disabled //тест не будет запущен,  в отчет попадет как ignored
    void disabledJUnitTest() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @DisplayName("Сложение двух чисел")
    void JUnitTestWithName() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Tag("sum")//тег конкретного теста
    void JUnitTestWithTag() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    @Timeout(value = 2)
    void JUnitTestWithTimeout() throws InterruptedException {
        Thread.sleep(2000);
        int actualSum = 2 + 2;
        int expectedSum = 4;
        assertEquals(expectedSum, actualSum);
    }


    @RepeatedTest(value = 3, name = "Сложение двух чисел - повторение {currentRepetition} из {totalRepetitions}")
    void repeatedJUnitTest() {
        int actualSum = 2 + 2;
        int expectedSum = 5;
        assertEquals(expectedSum, actualSum);
    }

    @Test
    void JUnitTestWithAssertEquals() {
        int actualSum = 2 + 2;
        int expectedSum = 5;
        // Используем assertTrue, assertFalse, assertEquals и другие методы Assertions
        assertEquals(expectedSum, actualSum, "Суммы должны одинаковыми");
    }

    @Test
    void JUnitTestAssertBoolean() {
        int actualSum = 2 + 2;
        int expectedSum = 4;
        boolean result = actualSum == expectedSum;
        assertTrue(result);
        assertFalse(result, "Суммы должны быть разными");
    }

    @Test
    void JUnitTestAssertThrows() {
        String name = null;
        // Проверяем, что при попытке работать с null строкой выбрасывается исключение NullPointerException
        assertThrows(NullPointerException. class, () -> name.length(),
                "Должно быть выброшено исключение NullPointerException");
    }

    @Test
    void JUnitTestAssertAll() {
        User user = new User("John", "Doe", 30);
        assertAll(
                () -> assertEquals("John1", user.getFirstName(), "Неправильное имя"),
                () -> assertEquals("Doe2", user.getLastName(), "Неправильная фамилия"),
                () -> assertEquals(31, user.getAge(),  "Неправильный возраст")
        );
    }

    @Test
    void JUnitTestAssertAllSeparate() {
        User user = new User("John", "Doe", 30);
        assertEquals("John1", user.getFirstName(), "Неправильное имя");
        assertEquals("Doe2", user.getLastName(), "Неправильная фамилия");
        assertEquals(31, user.getAge(),  "Неправильный возраст");
    }
}

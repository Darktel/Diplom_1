package praktikum;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class IngredientTypeTest {

    @Test
    void shouldHaveCorrectNames() {
        // Проверяем, что имена констант совпадают с ожидаемыми
        assertEquals("SAUCE", IngredientType.SAUCE.name());
        assertEquals("FILLING", IngredientType.FILLING.name());
    }


    @ParameterizedTest
    @ValueSource(strings = {"SAUCE", "FILLING"})
    void shouldContainValue(String value) {
        assertNotNull(IngredientType.valueOf(value));
    }

    @Test
    void shouldThrowExceptionForInvalidValueOf() {
        // Проверка, что при несуществующем имени выбрасывается исключение
        assertThrows(
                IllegalArgumentException.class,
                () -> IngredientType.valueOf("UNKNOWN")
        );
    }
}
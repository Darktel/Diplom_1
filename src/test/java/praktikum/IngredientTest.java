package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class IngredientTest {
    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        ingredient = new Ingredient(IngredientType.SAUCE, "Ketchup", 50.99f);
    }

    @Test
    void getPrice() {
        assertEquals(50.99f, ingredient.getPrice());
    }

    @Test
    void getName() {
        assertEquals("Ketchup", ingredient.getName());
    }

    @Test
    void getType() {
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }


    private static Stream<IngredientType> provideIngredientTypes() {
        return Stream.of(IngredientType.values());
    }

    @ParameterizedTest
    @MethodSource("provideIngredientTypes")
    void shouldAcceptAllIngredientTypes(IngredientType type) {
        // Arrange
        String name = "Test";
        float price = 5.0f;

        // Act & Assert
        assertDoesNotThrow(() -> new Ingredient(type, name, price));
    }

    @Test
    void shouldHandleZeroPrice() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "Cheese", 0.0f);
        assertEquals(0.0f, ingredient.getPrice(), 0.001f);
    }

    @Test
    void shouldHandleEmptyName() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "", 1.0f);
        assertEquals("", ingredient.getName());
    }

    @AfterEach
    void tearDown() {
        ingredient = null;
    }
}
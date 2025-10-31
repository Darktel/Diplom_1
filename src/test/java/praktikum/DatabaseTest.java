package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    private Database database;

    @BeforeEach
    void setUp() {
        database = new Database();
    }

    @AfterEach
    void tearDown() {
        database = null;
    }

    @Test
    void availableBuns() {
        List<Bun> buns = database.availableBuns();
        assertEquals(3, buns.size());
    }

    @Test
    void availableIngredients() {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(6, ingredients.size());
    }

    @ParameterizedTest
    @CsvSource({"black bun, 0", "white bun, 1", "red bun, 2"})
    void shouldInitializeWithCorrectBunsName(String bunName, int id) {
        List<Bun> buns = database.availableBuns();
        assertEquals(bunName, buns.get(id).getName());
    }

    @ParameterizedTest
    @CsvSource({"100, 0", "200, 1", "300, 2"})
    void shouldInitializeWithCorrectBunsPrice(int price, int id) {
        List<Bun> buns = database.availableBuns();
        assertEquals(price, buns.get(id).getPrice(), 0.001f);
    }

    @ParameterizedTest
    @CsvSource({"100, 0", "200, 1", "300, 2", "100, 3", "200, 4", "300, 5"})
    void shouldInitializeWithCorrectIngredientsPrice(int price, int id) {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(price, ingredients.get(id).getPrice(), 0.001f);

    }

    @ParameterizedTest
    @CsvSource({"hot sauce, 0", "sour cream, 1", "chili sauce, 2", "cutlet, 3", "dinosaur, 4", "sausage, 5"})
    void shouldInitializeWithCorrectIngredientsName(String ingredientName, int id) {
        List<Ingredient> ingredients = database.availableIngredients();
        assertEquals(ingredientName, ingredients.get(id).getName());

    }

    @ParameterizedTest
    @CsvSource({
            "0,SAUCE",
            "1,SAUCE",
            "2,SAUCE",
            "3,FILLING",
            "4,FILLING",
            "5,FILLING"
    })    void shouldInitializeWithCorrectIngredientsTypeIngredient(int index, String ingredientType) {
        List<Ingredient> ingredients = database.availableIngredients();

        IngredientType expectedType = IngredientType.valueOf(ingredientType);
        assertEquals(expectedType, ingredients.get(index).getType(),
                "Тип на позиции " + index + " должен быть " + ingredientType);
    }
}
package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BurgerTest {
    private Burger burger;

    @Mock
    Bun bun;

    @Mock
    Ingredient ingredient1;
    @Mock
    Ingredient ingredient2;

    @Mock
    Ingredient ingredient3;


    @BeforeEach
    void setUp() {
        burger = new Burger();
    }

    @AfterEach
    void tearDown() {
        burger = null;
    }

    @Test
    void initializeBurgerNullTest() {
        assertNull(burger.bun);
        assertTrue(burger.ingredients.isEmpty());

    }

    @Test
    void setBuns() {
        burger.setBuns(bun);
        when(bun.getName()).thenReturn("Лучшая булочка");
        when(bun.getPrice()).thenReturn(99.99f);
        assertTrue(burger.getReceipt().toString().split("\n")[0].contains("Лучшая булочка"));


    }

    @Test
    void addIngredient() {
        Burger burger = new Burger();
        when(bun.getName()).thenReturn("Лучшая булочка");
        when(bun.getPrice()).thenReturn(99.99f);
        when(ingredient1.getName()).thenReturn("sour cream");
        when(ingredient1.getPrice()).thenReturn(52.56f);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        assertTrue(burger.getReceipt().toString().split("\n")[1].contains("sour cream"));
    }

    @Test
    void removeIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    void moveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(2, 0);
        assertEquals(ingredient3, burger.ingredients.get(0));
    }

    @Test
    void getPrice() {
        when(bun.getPrice()).thenReturn(99.99f);
        when(ingredient1.getPrice()).thenReturn(22.56f);
        when(ingredient2.getPrice()).thenReturn(32.56f);
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(99.99f*2+22.56f+32.56f, burger.getPrice());
    }

}
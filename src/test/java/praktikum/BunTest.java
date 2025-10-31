package praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;

class BunTest {
    @Spy
    private Bun bun;

    @BeforeEach
    void setUp() {
        bun = new Bun("WhiteBread", 50.99f);
    }

    @AfterEach
    void tearDown() {
        bun = null;
    }

    @Test
    void getName() {
        assertEquals("WhiteBread", bun.getName());
    }

    @Test
    void getPrice() {
        assertEquals(50.99f, bun.getPrice());
    }
}
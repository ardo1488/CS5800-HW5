package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharColorTest {

    @Test
    void returnsColorGetColorTest() {
        CharColor c = new CharColor("Red");
        assertEquals("Red", c.getColor());
    }

    @Test
    void differentColorGetColorTest() {
        CharColor c = new CharColor("Blue");
        assertEquals("Blue", c.getColor());
    }
}

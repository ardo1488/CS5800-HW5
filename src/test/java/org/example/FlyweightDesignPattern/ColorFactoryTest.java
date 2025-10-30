package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ColorFactoryTest {

    @Test
    void createsWhenMissingGetCharColorTest() {
        CharColor c = ColorFactory.getCharColor("Magenta");
        assertNotNull(c);
        assertEquals("Magenta", c.getColor());
    }

    @Test
    void returnsCachedInstanceGetCharColorTest() {
        CharColor c1 = ColorFactory.getCharColor("Green");
        CharColor c2 = ColorFactory.getCharColor("Green");
        assertSame(c1, c2);
    }
}

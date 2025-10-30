package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FontFactoryTest {

    @Test
    void createsWhenMissingGetCharFontTest() {
        CharFont f = FontFactory.getCharFont("Roboto");
        assertNotNull(f);
        assertEquals("Roboto", f.getFont());
    }

    @Test
    void returnsCachedInstanceGetCharFontTest() {
        CharFont f1 = FontFactory.getCharFont("Arial");
        CharFont f2 = FontFactory.getCharFont("Arial");
        assertSame(f1, f2);
    }
}

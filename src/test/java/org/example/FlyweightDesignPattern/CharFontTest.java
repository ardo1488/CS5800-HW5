package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharFontTest {

    @Test
    void returnsFontGetFontTest() {
        CharFont f = new CharFont("Arial");
        assertEquals("Arial", f.getFont());
    }

    @Test
    void differentFontGetFontTest() {
        CharFont f = new CharFont("Times");
        assertEquals("Times", f.getFont());
    }
}

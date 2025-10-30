package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterStyleTest {

    @Test
    void returnsFontGetFontTest() {
        CharFont f = new CharFont("Arial");
        CharacterStyle cs = new CharacterStyle(f, new CharColor("Black"), new CharSize(12));
        assertSame(f, cs.getFont());
    }

    @Test
    void notNullGetFontTest() {
        CharacterStyle cs = new CharacterStyle(new CharFont("Courier"), new CharColor("Blue"), new CharSize(10));
        assertNotNull(cs.getFont());
    }

    @Test
    void setsFontSetFontTest() {
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), new CharSize(12));
        CharFont newF = new CharFont("Times");
        cs.setFont(newF);
        assertSame(newF, cs.getFont());
    }

    @Test
    void overridesExistingFontSetFontTest() {
        CharFont original = new CharFont("Arial");
        CharacterStyle cs = new CharacterStyle(original, new CharColor("Black"), new CharSize(12));
        CharFont replacement = new CharFont("Courier");
        cs.setFont(replacement);
        assertSame(replacement, cs.getFont());
        assertNotSame(original, cs.getFont());
    }

    @Test
    void returnsColorGetColorTest() {
        CharColor c = new CharColor("Red");
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), c, new CharSize(12));
        assertSame(c, cs.getColor());
    }

    @Test
    void notNullGetColorTest() {
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), new CharColor("Green"), new CharSize(12));
        assertNotNull(cs.getColor());
    }

    @Test
    void setsColorSetColorTest() {
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), new CharSize(12));
        CharColor newC = new CharColor("Blue");
        cs.setColor(newC);
        assertSame(newC, cs.getColor());
    }

    @Test
    void overridesExistingColorSetColorTest() {
        CharColor oldC = new CharColor("Black");
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), oldC, new CharSize(12));
        CharColor newC = new CharColor("Yellow");
        cs.setColor(newC);
        assertSame(newC, cs.getColor());
        assertNotSame(oldC, cs.getColor());
    }

    @Test
    void returnsSizeGetSizeTest() {
        CharSize s = new CharSize(14);
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), s);
        assertSame(s, cs.getSize());
    }

    @Test
    void notNullGetSizeTest() {
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), new CharSize(9));
        assertNotNull(cs.getSize());
    }

    @Test
    void setsSizeSetSizeTest() {
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), new CharSize(12));
        CharSize newS = new CharSize(20);
        cs.setSize(newS);
        assertSame(newS, cs.getSize());
    }

    @Test
    void overridesExistingSizeSetSizeTest() {
        CharSize oldS = new CharSize(12);
        CharacterStyle cs = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), oldS);
        CharSize newS = new CharSize(8);
        cs.setSize(newS);
        assertSame(newS, cs.getSize());
        assertNotSame(oldS, cs.getSize());
    }
}

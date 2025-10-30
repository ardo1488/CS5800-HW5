package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharTest {

    @Test
    void returnsCharacterGetCharacterTest() {
        CharacterStyle style = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), new CharSize(12));
        Char ch = new Char('A', style);
        assertEquals('A', ch.getCharacter());
    }

    @Test
    void differentCharacterGetCharacterTest() {
        CharacterStyle style = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), new CharSize(12));
        Char ch = new Char('Z', style);
        assertEquals('Z', ch.getCharacter());
    }

    @Test
    void returnsStyleGetCharacterStyleTest() {
        CharacterStyle style = new CharacterStyle(new CharFont("Arial"), new CharColor("Black"), new CharSize(12));
        Char ch = new Char('A', style);
        assertSame(style, ch.getCharacterStyle());
    }

    @Test
    void notNullStyleGetCharacterStyleTest() {
        CharacterStyle style = new CharacterStyle(new CharFont("Times"), new CharColor("Red"), new CharSize(16));
        Char ch = new Char('B', style);
        assertNotNull(ch.getCharacterStyle());
    }
}

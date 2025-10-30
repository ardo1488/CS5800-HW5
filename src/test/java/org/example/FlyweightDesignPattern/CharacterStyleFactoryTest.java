package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterStyleFactoryTest {

    @Test
    void cachesSameKeyGetCharacterStyleTest() {
        CharacterStyle a = CharacterStyleFactory.getCharacterStyle("Arial", "Black", 12);
        CharacterStyle b = CharacterStyleFactory.getCharacterStyle("Arial", "Black", 12);
        assertSame(a, b);
    }

    @Test
    void differentKeyDifferentInstanceGetCharacterStyleTest() {
        CharacterStyle a = CharacterStyleFactory.getCharacterStyle("Arial", "Black", 12);
        CharacterStyle b = CharacterStyleFactory.getCharacterStyle("Arial", "Black", 14);
        assertNotSame(a, b);
    }
}

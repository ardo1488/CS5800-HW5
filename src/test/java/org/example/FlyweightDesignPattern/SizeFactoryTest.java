package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SizeFactoryTest {

    @Test
    void createsWhenMissingGetCharSizeTest() {
        CharSize s = SizeFactory.getCharSize(18);
        assertNotNull(s);
        assertEquals(18, s.getSize());
    }

    @Test
    void returnsCachedInstanceGetCharSizeTest() {
        CharSize s1 = SizeFactory.getCharSize(12);
        CharSize s2 = SizeFactory.getCharSize(12);
        assertSame(s1, s2);
    }
}

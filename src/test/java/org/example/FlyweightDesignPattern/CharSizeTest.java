package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSizeTest {

    @Test
    void returnsSizeGetSizeTest() {
        CharSize s = new CharSize(12);
        assertEquals(12, s.getSize());
    }

    @Test
    void differentSizeGetSizeTest() {
        CharSize s = new CharSize(20);
        assertEquals(20, s.getSize());
    }
}

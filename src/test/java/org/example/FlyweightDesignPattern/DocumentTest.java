package org.example.FlyweightDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class DocumentTest {

    @Test
    void appendsCharactersStoreCharacterTest() {
        Document doc = new Document();
        doc.storeCharacter('H', "Arial", "Black", 12);
        doc.storeCharacter('i', "Arial", "Black", 12);
        assertEquals("Hi", doc.toString());
    }

    @Test
    void usesFlyweightStoreCharacterTest() {
        Document doc = new Document();
        doc.storeCharacter('A', "Times", "Red", 16);
        doc.storeCharacter('B', "Times", "Red", 16);
        assertEquals("AB", doc.toString());
    }

    @Test
    void emptyDocumentToStringTest() {
        Document doc = new Document();
        assertEquals("", doc.toString());
    }

    @Test
    void concatenatesAllCharsToStringTest() {
        Document doc = new Document();
        for (char c : "ABC".toCharArray()) {
            doc.storeCharacter(c, "Arial", "Black", 12);
        }
        assertEquals("ABC", doc.toString());
    }

    @Test
    void printsFormattedSingleCharPrintTest() {
        Document doc = new Document();
        doc.storeCharacter('X', "Arial", "Blue", 10);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(baos));
        try {
            doc.print();
        } finally {
            System.setOut(old);
        }

        String out = baos.toString().trim();
        assertTrue(out.contains("X [Font=Arial, Color=Blue, Size=10]"));
    }

    @Test
    void printsMultipleLinesPrintTest() {
        Document doc = new Document();
        doc.storeCharacter('Y', "Times", "Red", 11);
        doc.storeCharacter('Z', "Times", "Red", 11);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(baos));
        try {
            doc.print();
        } finally {
            System.setOut(old);
        }

        String[] lines = baos.toString().trim().split("\\R+");
        assertEquals(2, lines.length);
        assertTrue(lines[0].contains("Y [Font=Times, Color=Red, Size=11]"));
        assertTrue(lines[1].contains("Z [Font=Times, Color=Red, Size=11]"));
    }
}

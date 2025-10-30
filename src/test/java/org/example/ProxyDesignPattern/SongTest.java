package org.example.ProxyDesignPattern;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SongTest {

    @Test
    void returnsInitialIdGetIdTest() {
        Song s = new Song(1, "T", "A", "B", 3);
        assertEquals(1, s.getId());
    }

    @Test
    void updatesIdSetIdTest() {
        Song s = new Song(1, "T", "A", "B", 3);
        s.setId(42);
        assertEquals(42, s.getId());
    }

    @Test
    void returnsInitialTitleGetTitleTest() {
        Song s = new Song(1, "Hello", "A", "B", 3);
        assertEquals("Hello", s.getTitle());
    }

    @Test
    void updatesTitleSetTitleTest() {
        Song s = new Song(1, "Old", "A", "B", 3);
        s.setTitle("New");
        assertEquals("New", s.getTitle());
    }

    @Test
    void returnsInitialArtistGetArtistTest() {
        Song s = new Song(1, "T", "Artist", "B", 3);
        assertEquals("Artist", s.getArtist());
    }

    @Test
    void updatesArtistSetArtistTest() {
        Song s = new Song(1, "T", "OldArtist", "B", 3);
        s.setArtist("NewArtist");
        assertEquals("NewArtist", s.getArtist());
    }

    @Test
    void returnsInitialAlbumGetAlbumTest() {
        Song s = new Song(1, "T", "A", "Album1", 3);
        assertEquals("Album1", s.getAlbum());
    }

    @Test
    void updatesAlbumSetAlbumTest() {
        Song s = new Song(1, "T", "A", "OldAlb", 3);
        s.setAlbum("NewAlb");
        assertEquals("NewAlb", s.getAlbum());
    }

    @Test
    void returnsInitialDurationGetDurationTest() {
        Song s = new Song(1, "T", "A", "B", 123);
        assertEquals(123, s.getDuration());
    }

    @Test
    void updatesDurationSetDurationTest() {
        Song s = new Song(1, "T", "A", "B", 1);
        s.setDuration(240);
        assertEquals(240, s.getDuration());
    }

    @Test
    void containsAllFieldsToStringTest() {
        Song s = new Song(7, "Joy", "Singer", "Alb", 4);
        String out = s.toString();
        assertTrue(out.contains("ID: 7"));
        assertTrue(out.contains("Song: Joy"));
        assertTrue(out.contains("Artist: Singer"));
        assertTrue(out.contains("Album: Alb"));
        assertTrue(out.contains("Duration: 4"));
    }

    @Test
    void reflectsUpdatedFieldsToStringTest() {
        Song s = new Song(1, "OldTitle", "OldArtist", "OldAlbum", 1);
        s.setId(9);
        s.setTitle("NewTitle");
        s.setArtist("NewArtist");
        s.setAlbum("NewAlbum");
        s.setDuration(99);
        String out = s.toString();

        assertTrue(out.contains("ID: 9"));
        assertTrue(out.contains("Song: NewTitle"));
        assertTrue(out.contains("Artist: NewArtist"));
        assertTrue(out.contains("Album: NewAlbum"));
        assertTrue(out.contains("Duration: 99"));
    }
}

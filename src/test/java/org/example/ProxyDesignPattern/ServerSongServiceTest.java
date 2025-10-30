package org.example.ProxyDesignPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServerSongServiceTest {

    private ServerSongService server;

    @SuppressWarnings("unchecked")
    @BeforeEach
    void setUp() throws Exception {

        Field f = ServerSongService.class.getDeclaredField("songs");
        f.setAccessible(true);
        ((List<Song>) f.get(null)).clear();
        server = new ServerSongService();
    }


    @Test
    void returnsSongWhenIdExistsSearchByIdTest() {
        Song s = new Song(1, "Happy", "Singer", "A", 3);
        ServerSongService.addSong(s);

        Song found = server.searchById(1);
        assertNotNull(found);
        assertEquals(1, found.getId());
        assertEquals("Happy", found.getTitle());
    }

    @Test
    void returnsNullWhenIdMissingSearchByIdTest() {
        ServerSongService.addSong(new Song(1, "Happy", "Singer", "A", 3));
        Song missing = server.searchById(999);
        assertNull(missing);
    }


    @Test
    void returnsAllMatchesByExactTitleSearchByTitleTest() {
        ServerSongService.addSong(new Song(1, "Happy", "S1", "A", 3));
        ServerSongService.addSong(new Song(2, "Happy", "S2", "B", 4));
        ServerSongService.addSong(new Song(3, "Joy", "S3", "C", 5));

        var result = server.searchByTitle("Happy");
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(s -> s.getTitle().equals("Happy")));
    }

    @Test
    void returnsEmptyListWhenNoTitleMatchSearchByTitleTest() {
        ServerSongService.addSong(new Song(1, "Happy", "S1", "A", 3));

        var result = server.searchByTitle("NonExistingTitle");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    @Test
    void returnsAllMatchesByExactAlbumSearchByAlbumTest() {
        ServerSongService.addSong(new Song(1, "Happy", "S1", "TheAlbum", 3));
        ServerSongService.addSong(new Song(2, "Joy", "S2", "TheAlbum", 4));
        ServerSongService.addSong(new Song(3, "Sad", "S3", "OtherAlbum", 5));

        var result = server.searchByAlbum("TheAlbum");
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(s -> s.getAlbum().equals("TheAlbum")));
    }

    @Test
    void returnsEmptyListWhenNoAlbumMatchSearchByAlbumTest() {
        ServerSongService.addSong(new Song(1, "Happy", "S1", "A", 3));

        var result = server.searchByAlbum("UnknownAlbum");
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    @Test
    void addsSongThenFindsItAddSongTest() {
        Song s = new Song(7, "NewSong", "Artist", "Alb", 3);
        ServerSongService.addSong(s);

        Song found = server.searchById(7);
        assertNotNull(found);
        assertEquals("NewSong", found.getTitle());
    }

    @Test
    void addsMultipleSongsThenAllRetrievableAddSongTest() {
        ServerSongService.addSong(new Song(1, "A", "X", "AA", 1));
        ServerSongService.addSong(new Song(2, "B", "Y", "BB", 2));

        assertNotNull(server.searchById(1));
        assertNotNull(server.searchById(2));
    }
}

package org.example.ProxyDesignPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProxySongServiceTest {

    private ProxySongService proxy;
    private ServerSongService server;

    @SuppressWarnings("unchecked")
    @BeforeEach
    void setUp() throws Exception {

        Field fs = ServerSongService.class.getDeclaredField("songs");
        fs.setAccessible(true);
        ((List<Song>) fs.get(null)).clear();

        Field fc = ProxySongService.class.getDeclaredField("songCache");
        fc.setAccessible(true);
        ((List<Song>) fc.get(null)).clear();

        proxy = new ProxySongService();
        server = new ServerSongService();
    }


    @Test
    void missThenFetchesAndCachesSearchByIdTest() throws Exception {
        ServerSongService.addSong(new Song(10, "T", "A", "ALB", 3));

        Song first = proxy.searchById(10);
        assertNotNull(first);
        assertEquals(10, first.getId());

        Song second = proxy.searchById(10);
        assertSame(first, second);
    }

    @Test
    void returnsFromCacheWhenPresentSearchByIdTest() throws Exception {
        ServerSongService.addSong(new Song(1, "A", "X", "AA", 1));

        proxy.searchById(1);


        Song again = proxy.searchById(1);
        assertNotNull(again);
        assertEquals(1, again.getId());
    }



    @Test
    void fetchesFromServerWhenCacheEmptySearchByTitleTest() {
        ServerSongService.addSong(new Song(1, "Happy", "S1", "A", 3));
        ServerSongService.addSong(new Song(2, "Happy", "S2", "B", 4));

        var result = proxy.searchByTitle("Happy");
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(s -> s.getTitle().equals("Happy")));
    }

    @Test
    void returnsOnlyCachedMatchesWhenCacheNotEmptySearchByTitleTest() {

        ServerSongService.addSong(new Song(1, "Happy", "S1", "A", 3));
        ServerSongService.addSong(new Song(2, "Happy", "S2", "B", 4));


        var initial = proxy.searchById(1);

        var result = proxy.searchByTitle("Happy");
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getId());
    }


    @Test
    void fetchesFromServerWhenCacheEmptySearchByAlbumTest() {
        ServerSongService.addSong(new Song(1, "X", "A1", "ALB", 3));
        ServerSongService.addSong(new Song(2, "Y", "A2", "ALB", 4));

        var result = proxy.searchByAlbum("ALB");
        assertEquals(2, result.size());
        assertTrue(result.stream().allMatch(s -> s.getAlbum().equals("ALB")));
    }

    @Test
    void returnsOnlyCachedMatchesWhenCacheNotEmptySearchByAlbumTest() {
        ServerSongService.addSong(new Song(1, "X", "A1", "ALB", 3));
        ServerSongService.addSong(new Song(2, "Y", "A2", "ALB", 4));

        proxy.searchById(2);

        var result = proxy.searchByAlbum("ALB");
        assertEquals(1, result.size());
        assertEquals(2, result.get(0).getId());
    }
}

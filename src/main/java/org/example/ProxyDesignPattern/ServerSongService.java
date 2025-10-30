package org.example.ProxyDesignPattern;

import java.util.List;
import java.util.ArrayList;

public class ServerSongService implements SongService{

    private final static List<Song> songs = new ArrayList<>();

    @Override
    public Song searchById(Integer songID){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        for (Song song : songs){
            if(song.getId() == songID){
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> result = new ArrayList<>();
        for(Song song : songs){
            if(song.getTitle().equals(title)){
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album){
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}

        List<Song> result = new ArrayList<>();
        for(Song song : songs){
            if(song.getAlbum().equals(album)){
                result.add(song);
            }
        }
        return result;
    }

    public static void addSong(Song song){
        songs.add(song);
    }
}

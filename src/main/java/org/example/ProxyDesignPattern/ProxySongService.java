package org.example.ProxyDesignPattern;

import java.util.List;
import java.util.ArrayList;

public class ProxySongService implements SongService{

    private final static List<Song> songCache = new ArrayList<>();
    private final SongService songDownloader = new ServerSongService();

    @Override
    public Song searchById(Integer songID){
        for(Song song : songCache){
            if(song.getId() == songID){
                return song;
            }
        }
        Song song = songDownloader.searchById(songID);
        songCache.add(song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title){
        List<Song> songs = new ArrayList<>();
        for(Song song : songCache){
            if(song.getTitle().equals(title)){
                songs.add(song);
            }
        }
        if (!(songs.isEmpty())){
            return songs;
        }
        songs = songDownloader.searchByTitle(title);
        songCache.addAll(songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album){
        List<Song> songs = new ArrayList<>();
        for(Song song : songCache){
            if(song.getAlbum().equals(album)){
                songs.add(song);
            }
        }
        if (!(songs.isEmpty())){
            return songs;
        }
        songs = songDownloader.searchByAlbum(album);
        songCache.addAll(songs);
        return songs;
    }
}

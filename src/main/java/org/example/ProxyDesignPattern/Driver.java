package org.example.ProxyDesignPattern;

import java.util.List;

public class Driver {

    public static void main(String[] args) {

        ServerSongService.addSong(new Song(1, "Happy", "Singer1", "Happy Album", 3));
        ServerSongService.addSong(new Song(2, "Joy", "Singer1", "Happy Album", 4));
        ServerSongService.addSong(new Song(3, "Sad", "Singer1", "Sad Album", 8));
        ServerSongService.addSong(new Song(4, "Window", "Singer2", "Window", 2));
        ServerSongService.addSong(new Song(5, "Running", "Singer2", "Love Running", 3));
        ServerSongService.addSong(new Song(6, "Sweat", "Singer2", "Love Running", 3));
        ServerSongService.addSong(new Song(7, "Sweet", "Singer3", "Sweet Album", 4));
        ServerSongService.addSong(new Song(8, "Freedom", "Singer4", "Free Album", 2));
        ServerSongService.addSong(new Song(9, "Happy", "Singer4", "Free Album", 5));
        ServerSongService.addSong(new Song(10, "Computer", "Singer5", "Computer Album", 5));

        SongService songService = new ProxySongService();

        Song song1 = songService.searchById(7);
        System.out.println(song1.toString());

        List<Song> songs2 = songService.searchByTitle("Happy");
        for (Song song : songs2) {
            System.out.println(song.toString());
        }


        Song song3 = songService.searchById(1);
        System.out.println(song3.toString());

        List<Song> songs4 = songService.searchByTitle("Sad");
        for (Song song : songs4) {
            System.out.println(song.toString());
        }

        Song song5 = songService.searchById(4);
        System.out.println(song5.toString());

        List<Song> songs6 = songService.searchByAlbum("Free Album");
        for (Song song : songs6) {
            System.out.println(song.toString());
        }

        List<Song> songs7 = songService.searchByTitle("Joy");
        for (Song song : songs7) {
            System.out.println(song.toString());
        }

        List<Song> songs8 = songService.searchByAlbum("Love Running");
        for (Song song : songs8) {
            System.out.println(song.toString());
        }

        Song song9 = songService.searchById(6);
        System.out.println(song9.toString());

        Song song10 = songService.searchById(10);
        System.out.println(song10.toString());
    }
}

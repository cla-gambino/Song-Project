package com.example.Song.Project.services;

import com.example.Song.Project.entities.Song;
import com.example.Song.Project.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    @Autowired
    SongRepository songRepository;

    public Song addSong(Song song) {
        song.setId(null);
        return songRepository.saveAndFlush(song);
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getSingleSong(Long id) {
        if (songRepository.existsById(id)) {
            return songRepository.findById(id).get();
        } else {
            return new Song();
        }
    }

    public List<Song> getSongByAuthor(String author) {
        return songRepository.findByAuthor(author);
    }

    public List<Song> getSongByTitle(String title) {
        return songRepository.findByTitle(title);
    }

    public Song updateSong(Long id, String author, String title) {
        if (songRepository.existsById(id)) {
            Song mySong = songRepository.findById(id).get();
            mySong.setAuthor(author);
            mySong.setTitle(title);
            return songRepository.saveAndFlush(mySong);
        } else {
            return new Song();
        }
    }

    public void deleteSingleSong(Long id) {
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
        }
    }

    public void deleteAllSongs() {
        songRepository.deleteAll();
    }
}

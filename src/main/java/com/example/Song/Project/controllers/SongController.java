package com.example.Song.Project.controllers;

import com.example.Song.Project.entities.Song;
import com.example.Song.Project.services.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    SongService songService;

    @PostMapping("/addSong")
    private Song addSong(@RequestBody Song song) {
        return songService.addSong(song);
    }

    @GetMapping("/getAllSongs")
    private List<Song> getAllSongs() {
        return songService.getAllSongs();
    }

    @GetMapping("/getSingleSong/{id}")
    private Song getSingleSong(@PathVariable Long id) {
        return songService.getSingleSong(id);
    }

    @GetMapping("/getSongByAuthor/{author}")
    private List<Song> getSongByAuthor(@PathVariable String author) {
        return songService.getSongByAuthor(author);
    }

    @GetMapping("/getSongByTitle/{title}")
    private List<Song> getSongByTitle(@PathVariable String title) {
        return songService.getSongByTitle(title);
    }

    @PatchMapping("/updateSong/{id}")
    private Song updateSong(@PathVariable Long id, @RequestParam(required = false) String author, @RequestParam(required = false) String title) {
        return songService.updateSong(id, author, title);
    }

    @DeleteMapping("/deleteSingleSong/{id}")
    private void deleteSingleSong(@PathVariable Long id) {
        songService.deleteSingleSong(id);
    }

    @DeleteMapping("/deleteAllSongs")
    private void deleteAllSongs() {
        songService.deleteAllSongs();
    }
}

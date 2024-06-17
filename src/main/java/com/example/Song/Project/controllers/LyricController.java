package com.example.Song.Project.controllers;

import com.example.Song.Project.entities.Lyric;
import com.example.Song.Project.services.LyricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/lyric")
public class LyricController {

    @Autowired
    LyricService lyricService;

    @PostMapping("/addLyric")
    private Lyric addLyric(@RequestBody String lyric) {
        return lyricService.saveLyric(lyric);
    }

    @PostMapping("/addLyricFromFile")
    public Lyric addLyricFromFile(@RequestBody String filePath) {
        return lyricService.saveLyricFromFile(filePath);
    }

    @GetMapping("/getSingleLyric/{id}")
    private Lyric getSingleLyric(@PathVariable Long id) {
        return lyricService.getSingleLyric(id);
    }



    @DeleteMapping("/deleteSingleLyric/{id}")
    private void deleteSingleLyric(@PathVariable Long id) {
        lyricService.deleteSingleLyric(id);
    }

    @GetMapping("/searchInLyric/{id}")
    public List<String> searchInLyric(@PathVariable Long id, @RequestParam String keyword) {
        return lyricService.searchInLyric(id, keyword);
    }

    @GetMapping("/searchInAllLyrics")
    public List<String> searchInAllLyrics(@RequestParam String keyword) {
        return lyricService.searchInAllLyrics(keyword);
    }
}

package com.example.Song.Project.services;

import com.example.Song.Project.entities.Lyric;
import com.example.Song.Project.repositories.LyricRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class LyricService {

    @Autowired
    LyricRepository lyricRepository;

    public Lyric saveLyric(String lyric) {
        Lyric myLyric = new Lyric();
        myLyric.setLyric(lyric);
        return lyricRepository.saveAndFlush(myLyric);
    }

    public Lyric saveLyricFromFile(String filePath) {
        try {
            String content = new String(Files.readAllBytes(Paths.get(filePath)));
            Lyric myLyric = new Lyric();
            myLyric.setLyric(content);
            return lyricRepository.saveAndFlush(myLyric);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Lyric getSingleLyric(Long id) {
        return lyricRepository.findById(id).orElse(null);
    }

    public void deleteSingleLyric(Long id) {
        if (lyricRepository.existsById(id)) {
            lyricRepository.deleteById(id);
        }
    }

    public List<String> searchInLyric(Long id, String keyword) {
        Lyric lyric = lyricRepository.findById(id).orElse(null);
        if (lyric == null) {
            return null;
        }
        String lowerCaseKeyword = keyword.toLowerCase();
        return Stream.of(lyric.getLyric().split("\n"))
                .filter(line -> line.toLowerCase().contains(lowerCaseKeyword))
                .collect(Collectors.toList());
    }

    public List<String> searchInAllLyrics(String keyword) {
        List<Lyric> allLyrics = lyricRepository.findAll();
        String lowerCaseKeyword = keyword.toLowerCase();
        return allLyrics.stream()
                .flatMap(lyric -> Stream.of(lyric.getLyric().split("\n")))
                .filter(line -> line.toLowerCase().contains(lowerCaseKeyword))
                .collect(Collectors.toList());
    }
}

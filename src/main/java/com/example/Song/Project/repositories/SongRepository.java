package com.example.Song.Project.repositories;

import com.example.Song.Project.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

    List<Song> findByAuthor(String author);

    List<Song> findByTitle(String title);
}

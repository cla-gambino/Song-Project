package com.example.Song.Project.repositories;

import com.example.Song.Project.entities.Lyric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LyricRepository extends JpaRepository<Lyric, Long> {
}

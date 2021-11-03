package com.example.lab2.repository;


import com.example.lab2.entity.Music;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MusicRepository extends CrudRepository<Music, Long> {
    ArrayList<Music> findByName(String name);
    ArrayList<Music> findByAuthorName(String authorName);
    void deleteByName(String name);
}

package com.example.lab2.repository;


import com.example.lab2.entity.Music;
import com.example.lab2.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MusicRepository extends CrudRepository<Music, Long> {
//    ArrayList<Music> findByAuthorName(String authorName);
    @Query("SELECT m FROM Music m WHERE m.authorName = ?1 AND m.user = ?2")
    ArrayList<Music> findByAuthorName(String authorName, Users users);

    @Query("SELECT m FROM Music m WHERE m.user = ?1")
    ArrayList<Music> findAllByUser(Users users);

    void deleteByName(String name);
}

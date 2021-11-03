package com.example.lab2.controllers;


import com.example.lab2.entity.Music;
import com.example.lab2.repository.MusicRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/music")
public class MusicController {

    @Autowired
    private MusicRepository musicRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addMusic(@RequestBody Music music) {
        musicRepository.save(music);
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<Music> searchMusic(@RequestParam(value = "authorName", required = false) String authorName) {
        System.out.println(authorName);
        if (authorName != null) {
            return new ResponseEntity(musicRepository.findByAuthorName(authorName), HttpStatus.OK);
        }
        return new ResponseEntity(musicRepository.findAll(), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/del")
    public ResponseEntity<String> delMusic(@RequestBody(required = false) String name) {
        System.out.println(name);
        if (name != null) {
            musicRepository.deleteByName(name);
            return new ResponseEntity<>("Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }
}

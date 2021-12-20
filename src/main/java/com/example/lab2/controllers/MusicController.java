package com.example.lab2.controllers;


import com.example.lab2.DTO.MessageDTO;
import com.example.lab2.entity.Music;
import com.example.lab2.entity.Users;
import com.example.lab2.repository.MusicRepository;
import com.example.lab2.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;


    @PostMapping("/add")
    public ResponseEntity<String> addMusic(@RequestBody MessageDTO messageDTO) {
        Users user = userRepository.getByLoginAndPassword(messageDTO.getLogin(), messageDTO.getPassword());
        Music music = new Music();
        music.setName(messageDTO.getName());
        music.setAuthorName(messageDTO.getAuthorName());
        music.setUser(user);
        musicRepository.save(music);
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
//        return new ResponseEntity(user, HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<Music> searchMusic(@RequestBody MessageDTO messageDTO) {
        Users users = userRepository.getByLoginAndPassword(messageDTO.getLogin(), messageDTO.getPassword());
        if (messageDTO.getAuthorName() != null) {
            return new ResponseEntity(musicRepository.findByAuthorName(messageDTO.getAuthorName(), users), HttpStatus.OK);
        }
        return new ResponseEntity(musicRepository.findAllByUser(users), HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/del")
    public ResponseEntity<String> delMusic(@RequestBody MessageDTO messageDTO) {
        if (messageDTO.getName() != null) {
            musicRepository.deleteByName(messageDTO.getName());
            return new ResponseEntity<>("Delete", HttpStatus.OK);
        }
        return new ResponseEntity<>("Error", HttpStatus.BAD_REQUEST);
    }
}

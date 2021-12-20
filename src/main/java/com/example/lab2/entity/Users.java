package com.example.lab2.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    private String password;
    @OneToMany
    private Set<Music> music;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Music> getMusic() {
        return music;
    }

    public void setMusic(Set<Music> music) {
        this.music = music;
    }

    public Users() {   }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

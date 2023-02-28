package com.anime.springboot.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "anime")
public class Anime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title", nullable = false)
    private String title;
    @Column(name = "type")
    private String type;
    @Column(name = "source")
    private String source;
    @Column(name = "watched")
    private boolean watched;

    public Anime() {}
    public Anime(String title, String type, String source, boolean watched) {
        this.title = title;
        this.type = type;
        this.source = source;
        if (watched == true) {
            this.watched = true;
        } else {
            this.watched = false;
        }
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return  title;
    }
    public String getType() {
        return type;
    }
    public String getSource() {
        return source;
    }
    public boolean getWatched() {
        return watched;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setSource(String source) {
        this.source = source;
    }
    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
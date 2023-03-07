package com.anime.springboot.service;

import com.anime.springboot.model.Anime;

import java.util.List;

public interface AnimeService {
    Anime saveAnime(Anime anime);
    List<Anime> getAllAnime();
    Anime getAnimeByID(int id);
    Anime updateAnime(Anime anime, int id);
    void deleteAnime(int id);
    List<Anime> watchedAnime(boolean watched);
    Anime[] get500Anime();
}

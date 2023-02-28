package com.anime.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anime.springboot.model.Anime;

import java.util.List;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Integer> {

}

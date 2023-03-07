package com.anime.springboot.controller;

import com.anime.springboot.model.Anime;
import com.anime.springboot.service.AnimeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/anime")
public class AnimeController {
    private AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        super();
        this.animeService = animeService;
    }

    @PostMapping()
    public ResponseEntity<Anime> saveAnime(@RequestBody Anime anime) {
        return new ResponseEntity<Anime>(animeService.saveAnime(anime), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

    @GetMapping
    @RequestMapping("watched")
    public List<Anime> watchedAnime() {
        return animeService.watchedAnime(true);
    }

    @GetMapping
    @RequestMapping("500")
    public Anime[] get500Animes() {
        return animeService.get500Anime();
    }

    @GetMapping("{id}")
    public ResponseEntity<Anime> getAnimeByID(@PathVariable("id") int id) {
        return new ResponseEntity<Anime>(animeService.getAnimeByID(id), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Anime> updateAnime(@PathVariable("id") int id, @RequestBody Anime anime) {
        return new ResponseEntity<Anime>(animeService.updateAnime(anime, id), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAnime(@PathVariable("id") int id) {
        animeService.deleteAnime(id);

        return new ResponseEntity<String>("Anime deleted!", HttpStatus.OK);
    }
}

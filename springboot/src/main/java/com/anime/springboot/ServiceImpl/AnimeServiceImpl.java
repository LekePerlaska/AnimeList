package com.anime.springboot.ServiceImpl;

import com.anime.springboot.exception.ResourceNotFoundException;
import com.anime.springboot.model.Anime;
import com.anime.springboot.repository.AnimeRepository;
import com.anime.springboot.service.AnimeService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnimeServiceImpl implements AnimeService {

    private AnimeRepository animeRepository;

    public  AnimeServiceImpl(AnimeRepository animeRepository) {
        super();
        this.animeRepository =animeRepository;
    }

    @Override
    public Anime saveAnime(Anime anime) {
        return animeRepository.save(anime);
    }

    @Override
    public List<Anime> getAllAnime() {
        return animeRepository.findAll();
    }

    @Override
    public Anime getAnimeByID(int id) {
        Optional<Anime> anime = animeRepository.findById(id);
        if(anime.isPresent()){
            return anime.get();
        }else {
            throw new ResourceNotFoundException("Anime", "ID", id);
        }
    }

    @Override
    public Anime ubdateAnime(Anime anime, int id) {
        Anime existingAnime = animeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Anime", "ID", id));

        existingAnime.setTitle(anime.getTitle());
        existingAnime.setType(anime.getType());
        existingAnime.setSource(anime.getSource());
        existingAnime.setWatched(anime.getWatched());

        animeRepository.save(existingAnime);
        return existingAnime;
    }

    @Override
    public void deleteAnime(int id) {
        animeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Anime", "ID", id));
        animeRepository.deleteById(id);
    }

    @Override
    public List<Anime> watchedAnime(boolean watched) {
        List<Anime> watchAnime = new ArrayList<Anime>();
        List<Anime> all = animeRepository.findAll();
        for(int i=0; i<all.size(); i++) {
            if(all.get(i).getWatched()) {
                watchAnime.add(all.get(i));
            }
        }
    return watchAnime;
    }

    @Override
    public Anime[] get500Anime() {
        Anime[] anime500 = new Anime[500];
        List<Anime> all = animeRepository.findAll();
        for(int i=0; i<anime500.length; i++) {
            anime500[i] = (all.get(i));
        }
    return anime500;
    }
}

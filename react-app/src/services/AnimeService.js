import axios from 'axios';

const ANIME_API_BASE_URL = "http://localhost:8080/api/anime";

class AnimeService {
    getAnimes() {
        return axios.get(ANIME_API_BASE_URL);
    }
    getWatchedAnimes() {
        return axios.get(ANIME_API_BASE_URL + "/watched");
    }
    getShortListAnime() {
        return axios.get(ANIME_API_BASE_URL + "/500");
    }
    updateAnime(anime, id) {
        if (!anime && !anime.id) {
            return;
        }
        return axios.put(ANIME_API_BASE_URL + "/" + id, anime);
    }
}

export default new AnimeService()
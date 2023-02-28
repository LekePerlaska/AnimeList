import axios from 'axios';

const ANIME_API_BASE_URL = "http://localhost:8080/api/anime";

class AnimeService {
    getAnimes() {
        return axios.get(ANIME_API_BASE_URL);
    }
    getWatchedAnimes() {
        return axios.get(ANIME_API_BASE_URL + "/watched");
    }
    get500Anime() {
        return axios.get(ANIME_API_BASE_URL + "/500");
    }
}

export default new AnimeService()
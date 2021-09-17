package academy.devdojo.roberto.springessentials.service;

import academy.devdojo.roberto.springessentials.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {
    private final List<Anime> animes =
            List.of(new Anime(1L, "Berserke"), new Anime(2L, "Pokemon"));


    public List<Anime> listAll(){
        return animes;
    }

    public Anime findById(long id){
        return animes.stream()
                .filter(anime -> anime.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime ID not FOund"));
    }
}

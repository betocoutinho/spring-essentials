package academy.devdojo.roberto.springessentials.service;

import academy.devdojo.roberto.springessentials.domain.Anime;
import academy.devdojo.roberto.springessentials.dto.request.AnimePutRequestBody;
import academy.devdojo.roberto.springessentials.dto.request.AnimesPostRequestBody;
import academy.devdojo.roberto.springessentials.mapper.AnimeMapper;
import academy.devdojo.roberto.springessentials.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimeService {
    private AnimeRepository animeRepository;


    public List<Anime> listAll() {

        return animeRepository.findAll();
    }

    public Anime findByIdThrowBadRequestException(long id) {
        return animeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Anime ID not FOund"));

    }


    public Anime save(AnimesPostRequestBody animesPostRequestBody) {


        return animeRepository.save(AnimeMapper.INSTANCE.toAnime(animesPostRequestBody));
    }

    public void delete(Long id) {

        animeRepository.delete(findByIdThrowBadRequestException(id));
    }

    public void replace(AnimePutRequestBody animePutRequestBody) {
       Anime savedAnime = findByIdThrowBadRequestException(animePutRequestBody.getId());
       Anime anime = AnimeMapper.INSTANCE.toAnime(animePutRequestBody);
       anime.setId(savedAnime.getId());

       animeRepository.save(anime);
    }
}

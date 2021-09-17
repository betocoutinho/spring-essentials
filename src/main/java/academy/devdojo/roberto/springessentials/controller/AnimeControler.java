package academy.devdojo.roberto.springessentials.controller;

import academy.devdojo.roberto.springessentials.domain.Anime;
import academy.devdojo.roberto.springessentials.service.AnimeService;
import academy.devdojo.roberto.springessentials.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/animes")
@Log4j2
@RequiredArgsConstructor
public class AnimeControler {

    private final DateUtil dateUtil;
    private final AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> listAll(){
        log.info(dateUtil.formatLocalDateTimetoDataBaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(animeService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findbyId(@PathVariable Long id){
        return ResponseEntity.ok(animeService.findById(id));
    }
}

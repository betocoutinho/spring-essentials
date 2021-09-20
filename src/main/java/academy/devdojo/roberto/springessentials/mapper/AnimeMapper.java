package academy.devdojo.roberto.springessentials.mapper;

import academy.devdojo.roberto.springessentials.domain.Anime;
import academy.devdojo.roberto.springessentials.dto.request.AnimePutRequestBody;
import academy.devdojo.roberto.springessentials.dto.request.AnimesPostRequestBody;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class AnimeMapper {
    public static final AnimeMapper INSTANCE = Mappers.getMapper(AnimeMapper.class);
    public abstract Anime toAnime(AnimesPostRequestBody animesPostRequestBody);

    public abstract Anime toAnime(AnimePutRequestBody animePutRequestBody);

}

package academy.devdojo.roberto.springessentials.dto.request;

import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class AnimePutRequestBody {
    private Long id;
    private String nome;
}

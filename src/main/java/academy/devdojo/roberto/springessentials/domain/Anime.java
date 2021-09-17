package academy.devdojo.roberto.springessentials.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class Anime {
    private Long id;
    private String nome;
}

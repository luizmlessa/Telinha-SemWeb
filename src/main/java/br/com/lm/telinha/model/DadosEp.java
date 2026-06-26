package br.com.lm.telinha.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEp(@JsonAlias("Title") String titulo,
                      @JsonAlias("Episode") Integer numEp,
                      @JsonAlias("imdbRating") String avaliacao,
                      @JsonAlias("Released") String dataLancamento) {
}

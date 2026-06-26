package br.com.lm.telinha.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.naming.LinkException;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemp(@JsonAlias("Season") Integer numero,
                        @JsonAlias("Episodes") List episodios) {
}

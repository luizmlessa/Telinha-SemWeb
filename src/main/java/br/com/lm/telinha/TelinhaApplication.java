package br.com.lm.telinha;

import br.com.lm.telinha.model.DadosSeries;
import br.com.lm.telinha.service.ConsumoApi;
import br.com.lm.telinha.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TelinhaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TelinhaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=breaking+bad&apikey=2e1a73b");
		ConverteDados conversor = new ConverteDados();
		DadosSeries dados = conversor.obterDados(json, DadosSeries.class);
		System.out.println(dados);
	}
}

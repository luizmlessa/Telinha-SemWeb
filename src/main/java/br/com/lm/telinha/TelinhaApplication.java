package br.com.lm.telinha;

import br.com.lm.telinha.model.DadosEp;
import br.com.lm.telinha.model.DadosSeries;
import br.com.lm.telinha.model.DadosTemp;
import br.com.lm.telinha.service.ConsumoApi;
import br.com.lm.telinha.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

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
		json = consumoApi.obterDados("http://www.omdbapi.com/?t=breaking+bad&season=5&episode=3&apikey=2e1a73b");
		DadosEp dadosEp = conversor.obterDados(json, DadosEp.class);
		System.out.println(dadosEp);

		List<DadosTemp> temps = new ArrayList<>();

		for (int i = 1; i <= dados.totalTemps(); i++){
			json = consumoApi.obterDados("http://www.omdbapi.com/?t=breaking+bad&season="+ i +"&apikey=2e1a73b");
			DadosTemp dadosTemp = conversor.obterDados(json, DadosTemp.class);
			temps.add(dadosTemp);
		}
		temps.forEach(System.out::println);

	}
}

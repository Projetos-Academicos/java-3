package challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import challenge.controller.LeitorCSV;
import challenge.model.Jogador;

public class Main {

	LeitorCSV leitorCSV = new LeitorCSV();
	List<Jogador> listaJogadores = leitorCSV.lerArquivoCSV();

	// Quantas nacionalidades (coluna `nationality`) diferentes existem no
	// arquivo?
	public int q1() {
		int qtnNacionalidade = 0;
		List<String> listaAux = new ArrayList<>();
		for (Jogador jogador : listaJogadores) {
			if (!listaAux.contains(jogador.getNationality())) {
				listaAux.add(jogador.getNationality());
				qtnNacionalidade++;
			}
		}
		return qtnNacionalidade;
	}

	// Quantos clubes (coluna `club`) diferentes existem no arquivo?
	// Obs: Existem jogadores sem clube.
	public int q2() {
		int qtnClub = 0;
		List<String> listaAux = new ArrayList<>();
		for (Jogador jogador : listaJogadores) {
			if (jogador.getClub() != null && !jogador.getClub().trim().isEmpty() ) {
				if (!listaAux.contains(jogador.getClub())) {
					listaAux.add(jogador.getClub());
					qtnClub++;
				}
			}
		}

		return qtnClub;
	}

	// Liste o primeiro nome (coluna `full_name`) dos 20 primeiros jogadores.
	public List<String> q3() {
		List<String> listaAux = new ArrayList<>();
		int count = 0;

		for (Jogador jogador : listaJogadores) {
			if (count < 20) {
				//String[] primeiroNome = jogador.getFull_name().split(" ");
				listaAux.add(jogador.getFull_name());
			}
			count++;
		}
		return listaAux;
	}

	// Quem são os top 10 jogadores que possuem as maiores cláusulas de
	// rescisão?
	// (utilize as colunas `full_name` e `eur_release_clause`)
	public List<String> q4() {
		List<String> listaAux = new ArrayList<>();
		
		int count = 0;
		Collections.sort(listaJogadores, new Comparator<Jogador>() {
			public int compare(Jogador o1, Jogador o2) {
				if (o1.getRecisao(o1.getEur_release_clause()).compareTo(o2.getRecisao(o2.getEur_release_clause())) < 0) {
					return 1;
				}
				if (o1.getRecisao(o1.getEur_release_clause()).compareTo(o2.getRecisao(o2.getEur_release_clause())) > 0) {
					return -1;
				} 
				return 0;
			}
		});

		for (Jogador jogador : listaJogadores) {
			if (count < 10) {
				listaAux.add(jogador.getFull_name());
			}

			count++;
		}
		
		return listaAux;
	}

	// Quem são os 10 jogadores mais velhos (use como critério de desempate o
	// campo `eur_wage`)?
	// (utilize as colunas `full_name` e `birth_date`)
	public List<String> q5() {
		List<String> listaAux = new ArrayList<>();
		int count = 0;
		Collections.sort(listaJogadores, new Comparator<Jogador>() {
			public int compare(Jogador o1, Jogador o2) {
				if (o1.getBirth_date().compareTo(o2.getBirth_date()) < 0) {
					return -1;
				}
				if (o1.getBirth_date().compareTo(o2.getBirth_date()) > 0) {
					return 1;
				} else {
					if (o1.getEur_wage().compareTo(o2.getEur_wage()) > 0) {
						return -1;
					}
					return 1;
				}
			}
		});

		for (Jogador jogador : listaJogadores) {
			if (count < 10) {
				listaAux.add(jogador.getFull_name());
			}

			count++;
		}

		return listaAux;
	}

	// Conte quantos jogadores existem por idade. Para isso, construa um mapa
	// onde as chaves são as idades e os valores a contagem.
	// (utilize a coluna `age`)
	public Map<Integer, Integer> q6() {

		Map<Integer, Integer> listaAux = new HashMap<>();

		for (Jogador jogador : listaJogadores) {
			Integer idade = Integer.parseInt(jogador.getAge());
			if (!listaAux.containsKey(idade)) {
				listaAux.put(idade, 1);
			} else {
				Integer count = listaAux.get(idade);
				listaAux.replace(idade, count + 1);
			}
		}
		return listaAux;
	}

}

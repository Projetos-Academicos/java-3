package challenge.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import challenge.model.Jogador;

public class LeitorCSV {

	public List<Jogador> lerArquivoCSV() {
		List<Jogador> listaJogadores = new ArrayList<>();

		try {
			BufferedReader arquivoCSV = new BufferedReader(
					new InputStreamReader(new FileInputStream("../java-3/src/main/resources/data.csv")));
			String linhaArquivo;
			Scanner lerArquivo = new Scanner(arquivoCSV);
			lerArquivo.nextLine();

			while (lerArquivo.hasNext()) {
				linhaArquivo = lerArquivo.nextLine();
				String[] JogadorAux = linhaArquivo.split(",");
				
				Jogador jogador = new Jogador();
				jogador.setFull_name(JogadorAux[2]);
				jogador.setClub(JogadorAux[3]);
				jogador.setAge(JogadorAux[6]);
				jogador.setBirth_date(JogadorAux[8]);
				jogador.setNationality(JogadorAux[14]);
				jogador.setEur_wage(JogadorAux[17]);
				jogador.setEur_release_clause(JogadorAux[18]);
				
				listaJogadores.add(jogador);
			}
			lerArquivo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return listaJogadores;
	}
}

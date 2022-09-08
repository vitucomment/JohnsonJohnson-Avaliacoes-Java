package primeiraAvaliação;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class SegundaQuestao {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		Map<String, Integer> votacao = populaCandidatos();
		chamaMenu();
		int qtdVotos = 1;
		int voto = 0;
		int votosValidos = 0;
		while (qtdVotos <= 5) {
			System.out.print("Digite o código do candidato para o " + qtdVotos + "º voto: ");
			try {
				voto = input.nextInt();
			} catch (InputMismatchException ex) {
				input.nextLine();
			}
			if (voto >= 1 && voto <= 4) {
				votacao = computaVotos(voto, votacao);
				votosValidos++;
			} else System.out.println("Opção inválida. O voto não será computado.");
			qtdVotos += 1;
		}
		geraPercentual(votacao, votosValidos);
		maisVotado(votacao);
		input.close();
	}

	public static void chamaMenu() {
		System.out.println("=========== Menu de Votação ===========");
		System.out.println("1 - Candidato A\n" + "2 - Candidato B\n" + "3 - Candidato C\n" + "4 - Voto Nulo");
		System.out.println("=======================================\n");
	}

	public static Map<String, Integer> populaCandidatos() {
		Map<String, Integer> candidatos = new HashMap<String, Integer>();
		candidatos.put("Candidato 1", 0);
		candidatos.put("Candidato 2", 0);
		candidatos.put("Candidato 3", 0);
		candidatos.put("Voto Nulo", 0);
		return candidatos;
	}

	public static Map<String, Integer> computaVotos(int voto, Map<String, Integer> votacao) {
		switch (voto) {
		case 1:	votacao.merge("Candidato 1", 1, Integer::sum);
			break;
		case 2: votacao.merge("Candidato 2", 1, Integer::sum);
			break;
		case 3: votacao.merge("Candidato 3", 1, Integer::sum);
			break;
		case 4: votacao.merge("Voto Nulo", 1, Integer::sum);
			break;
		}
		return votacao;
	}

	public static void geraPercentual(Map<String, Integer> votacao, int totalVotosValidos) {
		int votosValidos = (totalVotosValidos - votacao.get("Voto Nulo")) * 20;
		int votosA = (votacao.get("Candidato 1")) * 20;
		int votosB = (votacao.get("Candidato 2")) * 20;
		int votosC = (votacao.get("Candidato 3")) * 20;
		System.out.println("Percentual de Votos Válidos: " + votosValidos + "%");
		System.out.println("Percentual de Votos Candidato 1: " + votosA + "%");
		System.out.println("Percentual de Votos Candidato 2: " + votosB + "%");
		System.out.println("Percentual de Votos Candidato 3: " + votosC + "%");
	}

	public static void maisVotado(Map<String, Integer> votacao) {
		int votosA = (votacao.get("Candidato 1")) * 20;
		int votosB = (votacao.get("Candidato 2")) * 20;
		int votosC = (votacao.get("Candidato 3")) * 20;
		int maisVotadoAB = (votosA + votosB + Math.abs(votosA - votosB)) / 2;
		int maisVotadoABC = (maisVotadoAB + votosC + Math.abs(maisVotadoAB - votosC)) / 2;
		if (maisVotadoABC == votosA && maisVotadoABC == votosB || maisVotadoABC == votosA && maisVotadoABC == votosC
				|| maisVotadoABC == votosB && maisVotadoABC == votosC)
			System.out.println("EMPATE!");
		else {
			if (maisVotadoABC == votosA)System.out.println("Candidato vencedor: Candidato 1");
			else if (maisVotadoABC == votosB)System.out.println("Candidato vencedor: Candidato 2");
			else if (maisVotadoABC == votosC)System.out.println("Candidato vencedor: Candidato 3");
		}
	}
}

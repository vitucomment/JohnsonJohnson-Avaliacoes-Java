package primeiraAvaliação;

import java.util.*;

public class TerceiraQuestão {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int totalCriancas = 0;
		int totalAdolescentes = 0;
		int totalAdultos = 0;
		int totalMelhorIdade = 0;
		String pessoaMaisVelha = null;
		int maiorIdade = 0;

		for (int i = 1; i <= 3; i++) {
			try {

				System.out.print("Digite o nome do individuo 0" + i + ": ");
				String nome = input.nextLine();
				System.out.print("Digite a idade de " + nome + ": ");
				int idade = input.nextInt();
				input = new Scanner(System.in);
				System.out.print("Digite o sexo do(a) " + nome + ": ");
				char sexo = input.next().charAt(0);
				while (sexo != 'm' && sexo != 'f' && sexo != 'F' && sexo != 'M') {
					System.out.print("Valor inválido \nEscreva o sexo como [M || F]:  " + nome + ": ");
					sexo = input.next().charAt(0);
				}
				input = new Scanner(System.in);

				if (i == 1) {
					maiorIdade = idade;
					pessoaMaisVelha = nome;
				}
				if (maiorIdade < idade) {
					maiorIdade = idade;
					pessoaMaisVelha = nome;
				}

				if (idade <= 13) {
					System.out.println(nome + " é criança\n");
					totalCriancas++;
				} else if (idade <= 20) {
					System.out.println(nome + " é adolescente\n");
					totalAdolescentes++;
				} else if (idade <= 50) {
					System.out.println(nome + " é adulto\n");
					totalAdultos++;
				} else {
					System.out.println(nome + " é da melhor idade\n");
					totalMelhorIdade++;
				}
				
				;
			} catch (InputMismatchException ex) {
				input = new Scanner(System.in);
				System.out.println("O valor informado é inválido.\n");
			}
		}
		System.out.println("Total de crianças: " + totalCriancas);
		System.out.println("Total de adolescentes: " + totalAdolescentes);
		System.out.println("Total de adultos: " + totalAdultos);
		System.out.println("Total de melhor idade: " + totalMelhorIdade + "\n");
		System.out.println("O nome do individuo mais velho é: " + pessoaMaisVelha);
		input.close();
	}
}

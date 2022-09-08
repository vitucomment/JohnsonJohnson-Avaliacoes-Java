package primeiraAvaliação;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PrimeiraQuestão {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int quantiaSacada = 0;

		while (true) {
			try {
				System.out.print("Digite a quantidade de dinheiro a ser sacada: ");
				quantiaSacada = input.nextInt();
				if (quantiaSacada < 0) System.out.print(new QuantiaNegativaException().getMessage());
				else break;
			} catch (InputMismatchException ex) {
				input.next();
				System.out.print("Valor deve ser um número.\nDigite um valor válido: \n");
			}
		}

		System.out.println("Quantidades:");
		int[] valores = { 100, 50, 20, 10, 5, 2, 1 };
		for (int i = 0; i < valores.length; i++) {
			int qtdNotas = quantiaSacada / valores[i];
			quantiaSacada %= valores[i];
			System.out.println(qtdNotas + " notas = R$ " + valores[i] + " reais.");
		}
		input.close();
	}
}

class QuantiaNegativaException extends RuntimeException {
	// Gerei o serial só pra sumir o amarelinho na IDE
	private static final long serialVersionUID = 1L;

	public QuantiaNegativaException() {
		super("Valor não pode ser negativo\nDigite um valor válido: \n");
	}
}

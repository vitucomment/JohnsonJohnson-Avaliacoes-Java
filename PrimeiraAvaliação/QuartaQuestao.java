package primeiraAvaliação;

import java.text.DecimalFormat;
import java.util.*;

public class QuartaQuestao {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.00");

		double totalComprasAVista = 0;
		double totalComprasParceladas = 0;
		double totalDescontos = 0;
		double totalJuros = 0;

		for (int i = 1; i <= 5; i++) {
			try {
				System.out.println("Compra 0" + i);
				System.out.print("Digite o valor total: R$ ");
				double valorCompra = input.nextDouble();
				System.out.print("Digite a forma de pagamento: ");
				int formaPagamento = input.nextInt();
				if (formaPagamento >= 1 && formaPagamento <= 4) {
					if (formaPagamento == 1) {
						double valorTotal = valorCompra - valorCompra * 0.08;
						double desconto = valorCompra * 0.08;
						System.out.println("Desconto de 8%");
						System.out.println("Valor final: R$ " + (df.format(valorTotal)) + "\n");
						totalComprasAVista += valorTotal;
						totalDescontos += desconto;
					} else if (formaPagamento == 2) {
						double valorTotal = valorCompra - valorCompra * 0.04;
						double desconto = valorCompra * 0.04;
						System.out.println("Desconto de 4%");
						System.out.println("Valor final: R$ " + (df.format(valorTotal)) + "\n");
						totalComprasAVista += valorTotal;
						totalDescontos += desconto;
					} else if (formaPagamento == 3) {
						System.out.println("Em 2x de R$ " + df.format(valorCompra / 2));
						System.out.println("Valor final: R$ " + df.format(valorCompra) + "\n");
						totalComprasParceladas += valorCompra;
					} else if (formaPagamento == 4) {
						double valorFinal = valorCompra + valorCompra * 0.08;
						double juros = valorCompra * 0.08;
						System.out.println("Em 4x de R$ " + df.format(valorFinal / 4));
						System.out.println("Valor final: R$ " + df.format(valorFinal) + "\n");
						totalComprasParceladas += valorFinal;
						totalJuros += juros;
					}
				} else {
					input = new Scanner(System.in);
					System.out.println("Opção inválida. Digite um modo de pagamento válido.\n");
					System.out.println("A compra não será processada. \n");
				}
			} catch (InputMismatchException ex) {
				input = new Scanner(System.in);
				System.out.println("\nValor inválido. Digite apenas numeros.");
				System.out.println("A compra não será processada. \n");
			}
		}
		input.close();
		System.out.println("Total de compras \"À vista\": R$ " + df.format(totalComprasAVista));
		System.out.println("Total de compras \"parceladas\": R$ " + df.format(totalComprasParceladas) + "\n");
		System.out.println("Total de descontos: R$ " + df.format(totalDescontos));
		System.out.println("Total de juros: R$ " + df.format(totalJuros));
	}
}

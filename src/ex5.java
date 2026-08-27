import java.util.Scanner;

void main() {

    Scanner leitura = new Scanner(System.in);

    System.out.print("Digite o valor do empréstimo: R$ ");
    double valor = leitura.nextDouble();

    System.out.print("Digite a taxa de juros mensal (%): ");
    double juros = leitura.nextDouble();

    System.out.print("Digite o número de parcelas: ");
    int parcelas = leitura.nextInt();

    double taxa = juros / 100;

    double valorParcela = valor * (taxa * Math.pow(1 + taxa, parcelas)) / (Math.pow(1 + taxa, parcelas) - 1);

    double saldoDevedor = valor;
    double totalJuros = 0;

    System.out.println();
    System.out.println("--------------------------------------------------------------");
    System.out.println("      Amortização no sistema Francês de Amortização");
    System.out.println("                  (Tabela Price)");
    System.out.println("--------------------------------------------------------------");
    System.out.printf("Montante Financiado : R$ %.2f\n", valor);
    System.out.printf("Juros Financiamento : %.2f %%\n", juros);
    System.out.printf("Nº de Parcelas      : %d\n", parcelas);
    System.out.println("--------------------------------------------------------------");
    System.out.printf("%-8s %-15s %-15s %-12s %-15s\n", "Parcela", "Vlr Parcela", "Amortização", "Juros", "Sdo Devedor");

    for (int i = 1; i <= parcelas; i++) {

        double valorJuros = saldoDevedor * taxa;
        double amortizacao = valorParcela - valorJuros;

        saldoDevedor -= amortizacao;

        if (i == parcelas) {
            saldoDevedor = 0;
        }

        totalJuros += valorJuros;

        System.out.printf("%-8d R$ %-12.2f R$ %-12.2f R$ %-9.2f R$ %-12.2f\n", i, valorParcela, amortizacao, valorJuros, saldoDevedor);
    }

    System.out.printf("\nTotal de juros pago: R$ %.2f\n", totalJuros);
    System.out.println("--------------------------------------------------------------");

}
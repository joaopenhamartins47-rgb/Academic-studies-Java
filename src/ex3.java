import java.util.Scanner;

void main() {

    Scanner leitura = new Scanner(System.in);

    System.out.print("Digite o numero da conta: ");
    int num = leitura.nextInt();

    int original = num;
    int inverso = 0;
    int resto;

    while (num > 0) {
        resto = num % 10;
        inverso = inverso * 10 + resto;
        num /= 10;
    }

    int soma = original + inverso;

    int d1 = soma / 100, d2 = (soma / 10) % 10, d3 = soma % 10;

    int resultado = d1 * 1 + d2 * 2 + d3 * 3;
    int verificador = resultado % 10;

    System.out.println("Numero da conta: " + original);
    System.out.println("Inverso: " + inverso);
    System.out.println("Numero verificador: " + verificador);

}
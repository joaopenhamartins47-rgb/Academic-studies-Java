import java.util.Scanner;

void main() {
    Scanner leitura = new Scanner(System.in);

    System.out.println("### Menu ###");
    System.out.println("[1] - Calcular a média de 2 notas");
    System.out.println("[2] - Calcular a média de 3 notas");
    System.out.println("[3] - Calcular a média ponderada de 2 notas");
    System.out.println("[4] - Calcular a média de n notas");
    int op = leitura.nextInt();
    float n1, n2;
    switch (op){
        case 1:
            System.out.println("Digite a primeira nota: ");
            n1 = leitura.nextFloat();
            System.out.println("Digite a leitura da segunda nota");
            n2 = leitura.nextFloat();
            System.out.printf("A média é de: %.2f", (n1+n2)/2);
            break;

        case 2:
            float n3;
            System.out.println("Digite a primeira nota: ");
            n1 = leitura.nextFloat();
            System.out.println("Digite a leitura da segunda nota");
            n2 = leitura.nextFloat();
            System.out.println("Digite a leitura da terceira nota");
            n3 = leitura.nextFloat();
            System.out.printf("A média das 3 notas é de: %.2f", (n1+n2+n3)/3);

            break;

        case 3:
            float p1 = 1, p2 = 2;
            System.out.println("Digite a primeira nota: ");
            n1 = leitura.nextFloat();
            System.out.println("Digite a leitura da segunda nota");
            n2 = leitura.nextFloat();
            System.out.printf("A média ponderada das notas é de: %.2f", (n1*p1+n2*p2)/(p1+p2));
            break;

        case 4:
            float soma=0;
            System.out.println("Digite quantas notas deseja calcular");
            int n = leitura.nextInt();

            for(int i = 1; i<=n; i++){
                System.out.printf("Digite a %d nota: ", i);
                n1 = leitura.nextFloat();
                soma+=n1;
            }
            System.out.printf("A média é de: %.2f", soma/n);

            break;

        default:
            System.out.println("Opção inválida!");
    }

}
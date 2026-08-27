import java.util.Scanner;

void main() {

    Scanner scanner = new Scanner(System.in);

    System.out.print("Digite o dia: ");
    int dia = scanner.nextInt();

    System.out.print("Digite o mês: ");
    int mes = scanner.nextInt();

    System.out.print("Digite o ano: ");
    int ano = scanner.nextInt();

    boolean bissexto = false;

    if (ano % 400 == 0) {
        bissexto = true;
    } else if (ano % 4 == 0 && ano % 100 != 0) {
        bissexto = true;
    }

    int diasNoMes = 0;

    switch (mes) {
        case 1, 3, 5, 7, 8, 10, 12:
            diasNoMes = 31;
            break;

        case 4, 6, 9, 11:
            diasNoMes = 30;
            break;

        case 2:
            if (bissexto) {
                diasNoMes = 29;
            } else {
                diasNoMes = 28;
            }
    }
    boolean dataValida = false;
    if(ano > 0 && mes >= 1 && mes <= 12 && dia >= 1 && dia <= diasNoMes){
        dataValida = true;
    }

    if (dataValida) {

        int diasDecorridos = dia - 1;

        for (int m = 1; m < mes; m++)
        {
            if (m == 2) {
                if (bissexto) {
                    diasDecorridos += 29;
                } else {
                    diasDecorridos += 28;
                }
            }
            else if (m == 4 || m == 6 || m == 9 || m == 11) {
                diasDecorridos += 30;
            }
            else {
                diasDecorridos += 31;
            }
        }


        System.out.printf("Data válida: %02d/%02d/%d%n", dia, mes, ano);
        System.out.println("Ano bissexto: " + (bissexto ? "Sim" : "Não"));
        System.out.println("Dias passados: " + diasDecorridos);

    } else {
        System.out.println("Data inválida!");
    }

    scanner.close();
}
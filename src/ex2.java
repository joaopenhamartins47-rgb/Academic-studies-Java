import java.util.Scanner;
void main() {

    Scanner leitura = new Scanner(System.in);

    long num = leitura.nextLong();
    long maior = 0;
    while (num > 0){
        long resto = num%10;
        if(resto > maior)
            maior = resto;
        num /= 10;
    }

    System.out.println("O maior digito é: " + maior);

}
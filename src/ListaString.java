import java.util.Scanner;

void main() {
    /*
    1. Desenvolva um programa que solicita ao usuário a digitação de uma frase, depois verifica e exibe as
    vogais não existentes nesta frase.
    */

    //Como eu criei com static eu nao preciso chamar new, é só chamar direto
    Scanner leitura = new Scanner(System.in);
    System.out.println("Digite uma frase");
    String frase = leitura.nextLine();
    ListaString.verifica_vogais(frase);
}

public class ListaString{
    public static void verifica_vogais(String frase){
        boolean ta=false,te=false,ti=false,to=false,tu=false;
        frase=frase.toLowerCase();
        for(int i = 0; i<frase.length();i++){
            if(frase.charAt(i) == 'a')
                ta=true;
            else if(frase.charAt(i) == 'e')
                te=true;
            else if(frase.charAt(i) == 'i')
                ti=true;
            else if(frase.charAt(i) == 'o')
                to=true;
            else if(frase.charAt(i) == 'u')
                tu=true;
        }
        if (!ta)
            System.out.println("A");
        if (!te)
            System.out.println("E");
        if (!ti)
            System.out.println("I");
        if (!to)
            System.out.println("O");
        if (!tu)
            System.out.println("U");

    }
}

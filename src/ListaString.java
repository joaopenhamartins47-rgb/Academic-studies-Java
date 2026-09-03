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
    //ListaString.verifica_vogais(frase);
    ListaString.gerador_de_usernames();
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
    public static void gerador_de_usernames(){
        String consoantes="bcdfghjklmnpqrstvwxyz", vogais="aeiou";
        int i=0;
        while(i<5){
            int tamanho = (int)(Math.random()*3);
            if(tamanho == 0)
                tamanho =4;
            else if(tamanho == 1)
                tamanho = 6;
            else
                tamanho = 8;
            String username="";
            for(int j=0;j<tamanho;j++){
                if(j%2==0){
                    int pos = (int)(Math.random()*consoantes.length());
                    username += consoantes.charAt(pos);
                }
                else{
                    int pos = (int)(Math.random()*vogais.length());
                    username += vogais.charAt(pos);
                }
            }
            System.out.println("Username: " + username);
            i++;
        }

    }

}

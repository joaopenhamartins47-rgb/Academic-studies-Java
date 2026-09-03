import java.util.Scanner;
import javax.swing.JOptionPane;

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

    /*
    2. Desenvolva um programa gerador de usernames. O programa deve gerar e apresentar 5 usernames
    aleatórios utilizando uma sequência de consoante + vogal com tamanhos variados de 4, 6 ou 8
    caracteres. Exemplos de possíveis usernames gerados: *bexa*, *Rinato*, *maruko*, *tovira*,
    *kitona*.
    Dica:
     Math.random() retorna um valor aleatório do tipo real entre 0 e 1. Se você quiser gerar um
    número aleatório entre 1 e 25, faça o seguinte comando: int n=(int)(Math.random()*25)+1
    */
    ListaString.gerador_de_usernames();
    /*
    3. Faça o metodo estático LerInt() em Java que recebe como parâmetro um título e uma mensagem. O
    metodo deve abrir uma caixa de entrada no estilo JOptionPane.showInputDialog(...) com o título e a
    mensagem recebidos como parâmetro e retornar na forma de um inteiro, o valor digitado pelo
    usuário. Caso o usuário digite um valor inválido a função deve retornar o valor zero. Faça também uma
    versão dessa função para a leitura de valores reais.
    */
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
    public static int ler_painel(String titulo, String mensagem){
            try {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE));
                return valor;
            }
            catch(Exception e) {
                return 0;
            }

        }
    }


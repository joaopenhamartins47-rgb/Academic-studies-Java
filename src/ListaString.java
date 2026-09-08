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
    ListaString.verifica_vogais(frase);

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
    //ListaString.ler_painel("Bem vindo", "Digite um valor inteiro");
    /*
    4. Faça um programa que, a partir de um texto digitado pelo usuário, conte o número de palavras
    (palavra é definida por qualquer sequência de caracteres delimitada por espaços em branco, virgula,
    ponto ou ponto e vírgula) e exiba o resultado. Dica: use o metodo split com expressões regulares para
    separar e posteriormente contar as palavras.

    */
    ListaString.cont_palavras_com_regex();

    /*
    5. Embaralhar as palavras é um tipo de quebra-cabeças que é popular com crianças. As letras em cada
    palavra são rearranjadas em uma ordem qualquer e a pessoa que está usando o quebra-cabeças tem
    que descobrir qual era a palavra original. Palavras com três e quatro letras são fáceis, mas quanto mais
    letras são adicionadas, o número de combinações possíveis cresce rapidamente, deixando o quebracabeças mais desafiador. Crie um método estático em Java que ao receber uma palavra qualquer
    como parâmetro a retorne de forma embaralhada.
    Ex: embaralhar(“Unoeste”); deve retornar algo do tipo: enostUe
    */
    System.out.println("Digite uma palavra pra embaralhar!");
    frase = leitura.next();
    System.out.printf("Palavra embaralhada: %s\n", ListaString.embaralhar_palavra(frase));
}

public class ListaString
{
    public static void verifica_vogais(String frase)
    {
        boolean ta=false,te=false,ti=false,to=false,tu=false;
        frase=frase.toLowerCase();
        for(int i = 0; i<frase.length();i++)
        {
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
    public static void gerador_de_usernames()
    {
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
    public static int ler_painel(String titulo, String mensagem)
    {
            try
            {
                int valor = Integer.parseInt(JOptionPane.showInputDialog(null, mensagem, titulo, JOptionPane.QUESTION_MESSAGE));
                return valor;
            }
            catch(Exception e)
            {
                return 0;
            }
    }

    public static void cont_palavras_com_regex()
    {
        System.out.println("Digite uma frase para contar as palavras!");
        Scanner leitura = new Scanner(System.in);
        String[] frase = leitura.nextLine().split("[\\s,.;]+");
        System.out.printf("Quantidade de palavras: %d\n", frase.length);
    }
    public static String embaralhar_palavra(String frase)
    {
        String copia = frase, embaralhar="";
        int tam = frase.length();
        while(tam > 0)
        {
            int pos = (int)(Math.random()*copia.length());
            embaralhar += copia.charAt(pos);
            copia = copia.substring(0, pos) + copia.substring(pos+1);
            tam--;
        }
        return embaralhar;

    }

}




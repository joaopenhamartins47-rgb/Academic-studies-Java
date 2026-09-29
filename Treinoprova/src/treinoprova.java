/*
Faça um programa simples que:

crie/abra o arquivo alunos.txt;
grave:
Joao
Maria
Carlos
feche o arquivo;
abra novamente para leitura;
leia as linhas e mostre no console;
feche o arquivo.
*/
import java.io.RandomAccessFile;
import java.io.IOException;
public class Arquivos {

    public static void gravarEler() {
        String caminho = "alunos.txt";

        try {
            RandomAccessFile arquivo = new RandomAccessFile(caminho, "rw");

            arquivo.setLength(0);

            arquivo.writeBytes("Joao\nMaria\nCarlos\n");
            arquivo.close();

            arquivo = new RandomAccessFile(caminho, "r"); // Modo "r" para leitura

            String linha = arquivo.readLine();
            while (linha != null)
            {
                System.out.println(linha);
                linha = arquivo.readLine();
            }
            arquivo.close();

        } catch (IOException e)
        {
            System.out.println("Erro ao manipular o arquivo: " + e.getMessage());
        }
    }
    /*
    Vetor + Math.random()
    Crie um vetor de 10 posições.
    Preencha cada posição com números aleatórios de 1 até 20
    mostrar todos os valores do vetor;
    contar quantos são pares;
    contar quantos são ímpares;
    mostrar o maior valor;
    calcular a soma de todos os elementos.
    */
    public static void vetor_aleatorio()
    {
        int[] vet = new int[10];
        for(int i = 0; i<vet.length; i++)
        {
            vet[i] = (int)(Math.random()*20+1);
        }
        //Exibicao
        int pares=0, impares=0, maior=0, soma=0;
        for(int i = 0; i<vet.length;i++)
        {
            if(vet[i] % 2 == 0)
                pares++;
            else
                impares++;

            if(vet[i] > maior)
                maior = vet[i];
            soma+= vet[i];
            System.out.print(vet[i] + " ");
        }
        System.out.println("Pares: " + pares + " Impares: " + impares + " Maior: " + maior + " Soma: " + soma);
    }
    /*
    Crie uma matriz 4 × 4 e preencha cada posição com valores aleatórios de 0 até 9:
    Depois, o programa deve:

    Mostrar a matriz.
    Somar todos os elementos da diagonal principal.
    Somar todos os elementos da diagonal secundária.
    Contar quantos valores pares existem na matriz.
    Mostrar o maior valor encontrado.
    */
    public static void matriz_aleatoria()
    {
        int[][] matriz = new int[4][4];

        int soma_d=0, soma_ds=0, pares=0, maior=0;
        for(int i = 0; i<matriz.length;i++)
        {
            for(int j = 0; j<matriz[i].length;j++)
            {
                matriz[i][j] = (int)(Math.random()*10);
            }
        }
        //Exibicao
        int col = matriz.length-1;
        for(int i = 0; i<matriz.length;i++)
        {
            for(int j = 0; j<matriz[i].length;j++)
            {
                if(matriz[i][j] % 2 == 0)
                    pares++;
                if(matriz[i][j] > maior)
                    maior = matriz[i][j];
                if(j == col)
                {
                    soma_ds+= matriz[i][j];
                    col--;
                }
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
        //Outro for so pq quero fazer de outro jeito a diagonal principal
        for(int i = 0; i<matriz.length; i++)
        {
            soma_d += matriz[i][i];
        }

        System.out.println("Pares: " + pares + " Soma da diagonal principal: " + soma_d + " Maior: " + maior + " Soma diagonal Secundaria: " + soma_ds);

    }
}




void main() {
    Arquivos.vetor_aleatorio();
    Arquivos.matriz_aleatoria();
}
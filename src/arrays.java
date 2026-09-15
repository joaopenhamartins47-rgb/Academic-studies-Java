import java.util.Scanner;

void main() {
    /*
    1) Crie uma aplicação que tenha um metodo estático capaz de receber um número inteiro longo (long) que
    representa a distância de uma cidade em km. Sua tarefa é decompor os dígitos dessa distância em um vetor
    de inteiros, em que cada dígito deverá ocupar uma posição individual do vetor. Por exemplo, se o metodo
    receber a distância 25, ele deve retornar o vetor {2, 5}. Se a distância for de for 1024, o retorno deve ser o
    vetor {1, 0, 2, 4}.
    Desenvolva esse metodo estático em Java e teste-o com diferentes distâncias para garantir seu
    funcionamento.
    */
    Scanner leitura = new Scanner(System.in);
    System.out.printf("Digite um valor inteiro");
    long num = leitura.nextLong();
    int vetor[] = new int[20];
    vetor = ListaArray.int_to_vet(num);
    ListaArray.exibir_vetor(vetor);
    /* 2) Matriz de números pares
    Uma matriz de números pares é uma matriz quadrada que contém apenas números
    pares, começando de 2 e seguindo sequencialmente. Desenvolva um programa em Java
    que implemente os seguintes métodos estáticos:
    a) Metodo geraMatrizPares(): que, ao receber uma ordem (n), gere uma matriz n x n e a preencha com
    números pares, começando de 2. Cada elemento da matriz deve ser um número par sequencial, na sequ
     */
    System.out.println("Digite o tamanho da matriz!");
    int n = leitura.nextInt();
    ListaArray.num_pares(n);
    int [][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };
    int soma = ListaArray.soma_diagonal(matriz);
    System.out.printf("Soma: %d", soma);
}

public class ListaArray
{
    public static int[] int_to_vet(long num)
    {
        String texto = String.valueOf(num);
        int[] vetor = new int[texto.length()];


        for(int i = 0; i<texto.length(); i++)
        {
            vetor[i] = texto.charAt(i) - '0';
        }
        return vetor;
    }
    public static void exibir_vetor(int[] vet)
    {
        for(int i =0; i<vet.length;i++)
            System.out.printf("[%d]", vet[i]);
    }
    public static void num_pares(int n)
    {
        int matriz[][] = new int[n][n];
        int num_par = 0;
        for(int lin=0; lin<n;lin++)
            for(int col = 0; col<n; col++)
                matriz[lin][col] = num_par+=2;
        ListaArray.exibir_matriz(matriz);
    }
    public static void exibir_matriz(int[][] matriz)
    {
        for(int lin=0; lin<matriz.length;lin++) {
            for (int col = 0; col < matriz.length; col++)
                System.out.printf("[%d] ", matriz[lin][col]);
            System.out.println("\n");
        }
    }
    public static int soma_diagonal(int[][] matriz)
    {
        int diagonal_lin = 0, diagonal_col=0, soma=0;
        for(int lin=0;lin<matriz.length; lin++)
        {
            for(int col=0;col<matriz.length;col++)
            {
                if(diagonal_col == col && diagonal_lin == lin)
                    soma+= matriz[lin][col];
            }
            diagonal_col++;
            diagonal_lin++;
        }
        return soma;
    }






}

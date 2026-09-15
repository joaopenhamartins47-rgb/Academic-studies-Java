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
    System.out.printf("Soma: %d\n", soma);
    /*
    3) Desenvolva um método estático em Java chamado `ordenarEFiltrar`, que recebe um vetor de números
        inteiros e um número inteiro `limite`. O método deve realizar as seguintes operações:
        a. Filtrar os elementos do vetor que são maiores do que o `limite` e armazená-los em um novo vetor.
        b. Ordenar o novo vetor em ordem crescente.
        c. Retornar o vetor ordenado.
        Se não houver elementos que atendam ao critério de filtragem (ou seja, se todos os elementos do
        vetor original forem menores ou iguais ao `limite`), o método deve retornar um vetor vazio.
        Por exemplo, se o vetor de entrada for `{7, 10, 3, 15, 8}` e o `limite` for `6`, o método deve retornar o vetor
        `{7, 8, 10, 15}`.
        Crie também um método `main` para testar o método `ordenarEFiltrar` com diferentes cenários, incluindo
        vetores com elementos que não atendem ao critério de filtragem.
    */
    int[] vet = {7, 10, 3, 15, 8};

    int[] resultado = ListaArray.ordenarEFiltrar(vet, 6);

    ListaArray.exibir_vetor(resultado);

    int[] vet2 = {1, 2, 3, 4, 5};

    int[] resultado2 = ListaArray.ordenarEFiltrar(vet2, 10);

    ListaArray.exibir_vetor(resultado2);
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
        System.out.println("\n");
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
    public static int[] ordenarEFiltrar(int[] vet, int limite)
    {
        int j=0, n=0;
        for(int i =0; i<vet.length; i++) //Verifica quantos limites tem
        {
            if(vet[i] > limite)
                n++;
        }
        int[] vetor_limite = new int[n];

        for(int i =0; i<vet.length;i++)
        {
            if(vet[i] > limite)
                vetor_limite[j++] = vet[i];

        }
        Arrays.sort(vetor_limite);
        return vetor_limite;
    }






}

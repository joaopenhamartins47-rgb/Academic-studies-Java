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

    /*
    4) Megasena
        A Mega-Sena é a maior loteria do Brasil. Os sorteios acontecem duas vezes por semana, às quartas-feiras
        e aos sábados. O princípio do jogo é simples: são sorteados seis números diferentes, compreendidos entre 01 e
        60 (inclusive). Os sorteios são realizados em globos duplos (duas gaiolas esféricas girando). Os números são
        sorteados em dígitos separados, que formam um número decimal de dois dígitos, de 01 a 60. A primeira gaiola
        tem esferas variando de 0 a 5 para o primeiro dígito, e a outra tem esferas variando de 0 a 9 para o segundo. O
        número 00 corresponde ao 60. Quando seis pares de números originais são extraídos o sorteio está concluído.
        Os apostadores podem apostar de seis a quinze números do total de 60.
        Desenvolva um algoritmo em Java que pergunte ao usuário quantos jogos ele irá fazer e qual a quantidade
        de números que ele irá apostar para estes jogos (todos deverão obedecer a mesma quantidade de números).
        Após, gere aleatoriamente os números para cada aposta (não é permitido números repetidos em uma mesma
        aposta), faça o sorteio da Mega-Sena (obedecendo a regra oficial) e por final analise todas as apostas, emitindo
        o resultado da apuração de cada uma delas
    */
    System.out.printf("Quantos jogos deseja fazer? ");
    int jogos = leitura.nextInt();

    System.out.printf("Quantos numeros tera cada aposta? ");
    int quantidade = leitura.nextInt();
    while(quantidade < 6 || quantidade > 15)
    {
        System.out.printf("Quantidade invalida! Digite um valor entre 6 e 15: ");
        quantidade = leitura.nextInt();
    }
    int[][] apostas = new int[jogos][quantidade];

    for(int i = 0; i < jogos; i++)
    {
        apostas[i] = ListaArray.geraAposta(quantidade); //Gera as apostas pra cada linha
    }

    int[] megasena = ListaArray.geraMegaSena();
    ListaArray.MostraMegaSena(megasena);

    for(int i = 0; i < jogos; i++)
    {
        ListaArray.MostraAposta(apostas[i]);

        int acertos = ListaArray.verificaAposta(apostas[i], megasena);

        System.out.printf("Acertos: %d\n", acertos);
    }
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

    public static int[] geraAposta(int num)
    {
        int[] aposta = new int[num];
        int i = 0;

        while(i < num)
        {
            int sorteado = (int)(Math.random() * 60) + 1;
            int repetido = 0;

            for(int j = 0; j < i; j++)
            {
                if(aposta[j] == sorteado)
                    repetido = 1;
            }

            if(repetido == 0)
            {
                aposta[i] = sorteado;
                i++;
            }
        }

        return aposta;
    }

    public static int[] geraMegaSena()
    {
        int[] megasena = new int[6];
        int i = 0;

        while(i < 6)
        {
            int sorteado = (int)(Math.random() * 60) + 1;
            int repetido = 0;

            for(int j = 0; j < i; j++)
            {
                if(megasena[j] == sorteado)
                    repetido = 1;
            }

            if(repetido == 0)
            {
                megasena[i] = sorteado;
                i++;
            }
        }

        return megasena;
    }

    public static int verificaAposta(int[] aposta, int[] megasena)
    {
        int acertos = 0;

        for(int i = 0; i < aposta.length; i++)
        {
            for(int j = 0; j < megasena.length; j++)
            {
                if(aposta[i] == megasena[j])
                    acertos++;
            }
        }

        return acertos;
    }

    public static void MostraMegaSena(int[] megasena)
    {
        System.out.printf("Mega-Sena: ");

        for(int i = 0; i < megasena.length; i++)
            System.out.printf("[%d] ", megasena[i]);

        System.out.println();
    }

    public static void MostraAposta(int[] aposta)
    {
        System.out.printf("Aposta: ");

        for(int i = 0; i < aposta.length; i++)
            System.out.printf("[%d] ", aposta[i]);

        System.out.println();
    }






}

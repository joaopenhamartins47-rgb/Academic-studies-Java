import java.util.Arrays;

void finalzero()
{
    //25. Compactar vetor
    //Receba um vetor contendo zeros e números.
    //Retorne um novo vetor colocando os zeros no final.

    //Entrada:
    //{0, 5, 0, 3, 8, 0, 2}

    //Saída:
    //{5, 3, 8, 2, 0, 0, 0}

    //Da pra eu utilizar two pointers aqui, copiar os nao zeros e depois colocar os 0 pro final

    int[] vetor1;
    vetor1 = new int[]{0, 5, 0, 3, 8, 0, 2};

    //Ou int[] vetor1 = {0, 5, 0, 3, 8, 0, 2}

    int pos=0;
    for(int i = 0; i<vetor1.length; i++)
    {
        if(vetor1[i] != 0)
        {
            vetor1[pos++] = vetor1[i];
        }
    }
    while(pos < vetor1.length)
    {
        vetor1[pos++] = 0;
    }
    System.out.println(Arrays.toString(vetor1));

}

void intersecao()
{
    /*26. Valores comuns entre dois vetores

    Receba:

    A = {2, 5, 8, 10, 15}
    B = {1, 5, 7, 10, 20}

    Retorne:

    {5, 10}

    Não coloque repetidos no resultado.
    */
    int[] vet1 = {2, 5, 8, 10, 15};
    int[] vet2 = {1, 5, 7, 10, 20};
    int[] resultado = new int[vet1.length];
    int pos=0;
    for(int i = 0; i<vet1.length; i++)
    {
        boolean encontrou=false;
        boolean existe=false;
        for(int j = 0; j<vet2.length && !encontrou; j++)
        {
            if(vet1[i] == vet2[j])
            {
                encontrou = true;
                for(int k = 0; k<pos && !existe; k++)
                {
                    if(resultado[k] == vet1[i])
                        existe = true;
                }
                if(!existe)
                    resultado[pos++] = vet1[i];
            }
        }
    }
    System.out.println(Arrays.toString(resultado));
}


void maior_soma(int[][] mat)
{
    int soma, maior=0, pos=0;
    for(int i = 0; i<mat.length; i++)
    {
        soma = 0;
        for(int j = 0; j<mat[i].length; j++)
        {
            soma += mat[i][j];
        }
        if(soma > maior)
        {
            maior = soma;
            pos = i;
        }
    }
    System.out.println("A linha com a maior soma eh a linha: " + pos + "\nCom a soma de: " + maior);
}

void espelhar_mat(int[][] mat)
{
    /*29. Matriz espelhada

    Receba:

    1 2 3
    4 5 6
    7 8 9

    e produza:

    3 2 1
    6 5 4
    9 8 7
    */
    int[][] mat_esp = new int[mat.length][mat[0].length];
    for(int i = 0; i<mat.length; i++)
    {
        int col = mat[i].length-1;
        for(int j = 0; j<mat[i].length; j++)
        {
            mat_esp[i][col--] = mat[i][j];
        }
    }
    for (int i = 0; i < mat_esp.length; i++) {
        for (int j = 0; j < mat_esp[i].length; j++) {
            System.out.print(mat_esp[i][j] + " ");
        }
        System.out.println();
    }
}

void main()
{
    finalzero();
    intersecao();
    int[][] mat1 = {
            {1, 3, 5, 7, 13},
            {2, 4, 6, 8, 10},
            {12, 5, 2, 1, 1}
    };
    maior_soma(mat1);
    espelhar_mat(mat1);

}

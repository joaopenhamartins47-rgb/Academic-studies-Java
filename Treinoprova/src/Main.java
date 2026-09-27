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


void main()
{
    finalzero();
}

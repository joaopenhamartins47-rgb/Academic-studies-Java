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



}

class GloboBingo
{
    //Atributos
    private int numeros[];
    private int qtdeAtual;
    private int maiorNumero;

    public void carregar()
    {
        carregar(75);
    }
    public void carregar(int qtde)
    {
        if(qtde > 0)
        {
            numeros = new int[qtde];
            for(int i = 0; i<qtde; i++)
            {
                numeros[i] = i+1;
            }
            qtdeAtual = qtde;
            maiorNumero = qtde;
        }
    }
    public int sortear()
    {
        //Faz o sorteio e depois remaneja
        int num_sorteado = -1;
        if(qtdeAtual > 0)
        {
            Random random = new Random();
            int pos_sorteada = random.nextInt();
            num_sorteado = numeros[pos_sorteada];
            //Remanejamento
            for(int i = pos_sorteada; i< qtdeAtual -1; i++)
                numeros[i] = numeros[i+1];
            qtdeAtual--;
        }
        return num_sorteado;

    }
    //Como eu nao posso pegar os dados da classe, pois sao privados, eu tenho que fazer funcoes que retornam ela
    public int obterQuantNumerosSorteados()
    {

    }
    public int obterQuantNumerosRestantes()
    {

    }
    public boolean devolverNumero(int numero)
    {

    }
    public boolean sorteado(int numero)
    {

    }
    public String obterRelacaoNumeroSorteado()
    {

    }

}



void main() {
    
}
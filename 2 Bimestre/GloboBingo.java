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
    public int obterQuantNumerosSorteados(){
        return maiorNumero-qtdeAtual;
    }
    public int obterQuantNumerosRestantes(){
        return qtdeAtual;
    }
    public boolean devolverNumero(int numero){
        boolean devolvido=false;
        if(numero>=1 && numero<=maiorNumero)
            if(sorteado(numero)) {
                numeros[qtdeAtual++] = numero;
                devolvido=true;
            }
        return devolvido;
    }
    //método privado que somente outros métodos executam
    private boolean sorteado(int numero){
        boolean flag=true;
        for(int i=0; i<qtdeAtual; i++)
            if(numeros[i]==numero)
                flag=false;
        return flag;
    }
    public String obterRelacaoNumerosSorteados(){
        String naoSorteados="";
        for(int i=0; i<maiorNumero; i++)
            if(!sorteado(i+1))
                naoSorteados+=(i+1)+" ";
        return naoSorteados;
    }

}



void main() {
    
}
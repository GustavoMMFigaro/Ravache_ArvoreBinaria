public class ArvoreAvl {
    private NoAvl raiz;

    public ArvoreAvl() {
        construirArvore();
    }

    private void construirArvore() {
        NoAvl A = new NoAvl(1);
        NoAvl B = new NoAvl(2);
        NoAvl C = new NoAvl(3);
        NoAvl D = new NoAvl(4);
        NoAvl E = new NoAvl(5);
        NoAvl F = new NoAvl(6);

        A.esquerda = B;
        A.direita = C;

        B.esquerda = D;
        B.direita = E;

        C.direita = F;

        this.raiz = A;
    }


    public int altura(NoAvl no){
        return (no == null) ? 0 : no.altura;
    }


    public int fatorBalanceamento(NoAvl no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    public NoAvl rotacionarDireita(NoAvl y) {
        NoAvl x = y.esquerda;
        NoAvl VarTemp = x.direita;

        x.direita = y;
        y.esquerda = VarTemp;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }


    public NoAvl rotacionarEsquerda(NoAvl x) {
        NoAvl y = x.direita;
        NoAvl VarTemp = y.esquerda;

        y.esquerda = x;
        x.direita = VarTemp;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }


    public NoAvl inserir(NoAvl no, int chave) {
        if (no == null)
            return new NoAvl(chave);
        if (chave < no.chave)
            no.esquerda = inserir(no.esquerda, chave);
        else if (chave > no.chave)
            no.direita = inserir(no.direita, chave);
        else
            return no;


        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && chave < no.esquerda.chave) 
            return rotacionarDireita(no);
        if (balanceamento < 1 && chave > no.direita.chave) 
            return rotacionarEsquerda(no);
        if (balanceamento > 1 && chave > no.esquerda.chave) {
            no.esquerda = rotacionarEsquerda(no.esquerda);
            return rotacionarDireita(no);   
        }     
        if (balanceamento < -1 && chave < no.direita.chave) {
            no.direita = rotacionarDireita(no.direita);
            return rotacionarEsquerda(no);
        }

        return no;
    }

    private NoAvl menorValor(NoAvl no) {
        NoAvl atual = no;
        while (atual.esquerda != null)
            atual = atual.esquerda;
        return atual;
    }

    public NoAvl exclusao(NoAvl no, int chave) {
        if (no == null) 
            return null;
        if (chave < no.chave) {
            no.esquerda = exclusao(no.esquerda, chave);
        } else if (chave > no.chave) {
            no.direita = exclusao(no.direita, chave);
        } else {
            if (no.esquerda == null) return no.direita;
            if (no.direita == null) return no.esquerda;

            NoAvl sucessor = menorValor(no.direita);
            no.chave = sucessor.chave;
            no.direita = exclusao(no.direita, sucessor.chave);
        }

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = fatorBalanceamento(no);

        if (balanceamento > 1 && fatorBalanceamento(no.esquerda) >= 0)
            return rotacionarDireita(no);

        if (balanceamento < -1 && fatorBalanceamento(no.direita) <= 0)
            return rotacionarEsquerda(no);


        return no;
    }

    private void emOrdemAvl(NoAvl no) {
        if (no != null) {
            emOrdemAvl(no.esquerda);
            System.out.print(no.chave + " ");
            emOrdemAvl(no.direita);
        }
    }

    public void printEmOrdemAvl() {
        emOrdemAvl(raiz);
        System.out.println();
    }
}

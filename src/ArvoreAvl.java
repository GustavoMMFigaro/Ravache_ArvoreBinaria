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


    public int altura(NoAvl N){
        return (N == null) ? 0 : N.altura;
    }


    public int pegarBalanceamento(NoAvl N) {
        return (N == null) ? 0 : altura(N.esquerda) - altura(N.direita);
    }

    public NoAvl rotacionarDireita(NoAvl y) {
        NoAvl x = y.esquerda;
        NoAvl T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }


        public NoAvl rotacionarEsquerda(NoAvl x) {
        NoAvl y = x.direita;
        NoAvl T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }


    public NoAvl inserir(NoAvl no, int valor) {
        if (no == null) return new NoAvl(valor);
        if (valor < no.valor)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor > no.valor)
            no.direita = inserir(no.direita, valor);
        else
            return no;


        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));

        int balanceamento = pegarBalanceamento(no);

        if (balanceamento > 1 && valor < no.esquerda.valor) 
            return rotacionarDireita(no);
        if (balanceamento < 1 && valor > no.direita.valor) 
            return rotacionarEsquerda(no);
        if (balanceamento > 1 && valor > no.esquerda.valor) {
            no.esquerda = rotacionarEsquerda(no.esquerda);
            return rotacionarDireita(no);   
        }     
        if (balanceamento < -1 && valor < no.direita.valor) {
            no.direita = rotacionarDireita(no.direita);
            return rotacionarEsquerda(no);
        }

        return no;
    }

    private void emOrdemAvl(NoAvl no) {
        if (no != null) {
            emOrdemAvl(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemAvl(no.direita);
        }
    }

    public void printEmOrdemAvl() {
        emOrdemAvl(raiz);
        System.out.println();
    }
}

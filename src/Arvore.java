public class Arvore {
    private No raiz;

    public Arvore() {
        construirArvore();
    }

    private void construirArvore() {
        No A = new No("A");
        No B = new No("B");
        No C = new No("C");
        No D = new No("D");
        No E = new No("E");
        No F = new No("F");

        A.esquerda = B;
        A.direita = C;

        B.esquerda = D;
        B.direita = E;

        C.direita = F;

        this.raiz = A;
    }

        public int contarNos() {
        return contarNosRec(raiz);
    }


    private int contarNosRec(No no) {
    if (no == null) {
        return 0;
    }
        return 1 + contarNosRec(no.esquerda) + contarNosRec(no.direita);
    }

    public void preOrdem() {
        preOrdemRec(raiz);
        System.out.println();
    }

    private void preOrdemRec(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdemRec(no.esquerda);
            preOrdemRec(no.direita);
        }
    }
}
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

    public void emOrdem() {
        emOrdemRec(raiz);
        System.out.println();
    }

    private void emOrdemRec(No no) {
        if (no != null) {
            emOrdemRec(no.esquerda);
            System.out.print(no.valor + " ");
            emOrdemRec(no.direita);
        }
    }

    public void posOrdem() {
        posOrdemRec(raiz);
        System.out.println();
    }

    private void posOrdemRec(No no) {
        if (no != null) {
            posOrdemRec(no.esquerda);
            posOrdemRec(no.direita);
            System.out.print(no.valor + " ");
        }
    }

    public void emNivel() {
        int altura = altura(raiz);
        for (int i = 1; i <= altura; i++) {
            imprimirNivel(raiz, i);
        }
        System.out.println();
    }

    private void imprimirNivel(No no, int nivel) {
        if (no == null) {
            return;
        }
        if (nivel == 1) {
            System.out.print(no.valor + " ");
        } else if (nivel > 1) {
            imprimirNivel(no.esquerda, nivel - 1);
            imprimirNivel(no.direita, nivel - 1);
        }
    }

    private int altura(No no) {
        if (no == null) {
            return 0;
        }
        int alturaEsq = altura(no.esquerda);
        int alturaDir = altura(no.direita);
        return 1 + Math.max(alturaEsq, alturaDir);
    }
}
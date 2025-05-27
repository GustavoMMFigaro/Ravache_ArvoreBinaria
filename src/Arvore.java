import java.util.Stack;

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
        return contarNosIterativo(raiz);
    }

    private int contarNosIterativo(No noInicial) {
        if (noInicial == null) {
            return 0;
        }

        int contador = 0;
        Stack<No> pilha = new Stack<>();
        pilha.push(noInicial);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            contador++;

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
        return contador;
    }

    public void preOrdem() {
        preOrdemIterativo(raiz);
        System.out.println();
    }

    private void preOrdemIterativo(No noInicial) {
        if (noInicial == null) {
            return;
        }

        Stack<No> pilha = new Stack<>();
        pilha.push(noInicial);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            System.out.print(atual.valor + " ");

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
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
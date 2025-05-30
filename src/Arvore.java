import java.util.LinkedList;
import java.util.Queue;
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

    public int contarNosFolha() {
        return contarNosFolhaIterativo(raiz);
    }

    private int contarNosFolhaIterativo(No noInicial) {
        if (noInicial == null) {
            return 0;
        }

        int contadorFolhas = 0;
        Stack<No> pilha = new Stack<>();
        pilha.push(noInicial);

        while (!pilha.isEmpty()) {
            No atual = pilha.pop();
            if (atual.esquerda == null && atual.direita == null) {
                contadorFolhas++;
            }

            if (atual.direita != null) {
                pilha.push(atual.direita);
            }
            if (atual.esquerda != null) {
                pilha.push(atual.esquerda);
            }
        }
        return contadorFolhas;
    }

    public int contarNosFolha2() {
        return contarNosFolhaRec(raiz);
    }


    private int contarNosFolhaRec(No no) {
        if (no == null) {
            return 0;
        }
        if (no.esquerda == null && no.direita == null) {
            return 1;
        }
        return contarNosFolhaRec(no.direita) + contarNosFolhaRec(no.esquerda);
    }

    public int contarNosFolha3() {
        return contarNosFolhaFila(raiz);
    }

    private int contarNosFolhaFila(No noInicial) {
        if (noInicial == null) {
            return 0;
        }

        int contadorFolhas = 0;
        Queue<No> fila = new LinkedList<>();
        fila.add(noInicial);

        while (!fila.isEmpty()) {
            No atual = fila.remove();
            if (atual.esquerda == null && atual.direita == null) {
                contadorFolhas++;
            }

            if (atual.direita != null) {
                fila.add(atual.direita);
            }
            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }
        }
        return contadorFolhas;
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
        emOrdemIterativo(raiz);
        System.out.println();
    }

    private void emOrdemIterativo(No noInicial) {
        if (noInicial == null) {
            return;
        }

        Stack<No> pilha = new Stack<>();
        No atual = noInicial;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();
            System.out.print(atual.valor + " ");

            atual = atual.direita;
        }
    }

    public void posOrdem() {
        posOrdemIterativo(raiz);
        System.out.println();
    }

    private void posOrdemIterativo(No noInicial) {
        if (noInicial == null) {
            return;
        }

        Stack<No> s1 = new Stack<>();
        Stack<No> s2 = new Stack<>();

        s1.push(noInicial);

        while (!s1.isEmpty()) {
            No temp = s1.pop();
            s2.push(temp);

            if (temp.esquerda != null) {
                s1.push(temp.esquerda);
            }
            if (temp.direita != null) {
                s1.push(temp.direita);
            }
        }

        while (!s2.isEmpty()) {
            No temp = s2.pop();
            System.out.print(temp.valor + " ");
        }
    }

    public void emNivel() {
        emNivelIterativo(raiz);
        System.out.println();
    }

    private void emNivelIterativo(No noInicial) {
        if (noInicial == null) {
            return;
        }

        Queue<No> fila = new LinkedList<>();
        fila.add(noInicial);

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");

            if (atual.esquerda != null) {
                fila.add(atual.esquerda);
            }

            if (atual.direita != null) {
                fila.add(atual.direita);
            }
        }
    }
}
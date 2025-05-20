public class Arvore {
    private No raiz;

    public Arvore(No raiz) {
        this.raiz = null;
    }

    public void inserir(String valor) {
    raiz = inserirRec(raiz, valor);
    }

    private No inserirRec(No atual, String valor) {
        if (atual == null) {
            return new No(valor);
        }
        if (valor.compareTo(atual.valor) < 0) {
            atual.esquerda = inserirRec(atual.esquerda, valor);
        } else if (valor.compareTo(atual.valor) > 0) {
            atual.direita = inserirRec(atual.direita, valor);
        }
        return atual;
    }
}
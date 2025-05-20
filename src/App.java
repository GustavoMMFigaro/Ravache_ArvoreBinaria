public class App {
    public static void main(String[] args) throws Exception {
        No raiz = new No("A");
        Arvore arvore = new Arvore(raiz);

        arvore.inserir("A");
        arvore.inserir("B");
        arvore.inserir("C");
        arvore.inserir("D");
        arvore.inserir("E");
        arvore.inserir("F");

        System.out.println("Total de nós na árvore binária: " + arvore.contarNos());
    }
}

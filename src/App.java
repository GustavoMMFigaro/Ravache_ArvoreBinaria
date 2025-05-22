public class App {
    public static void main(String[] args) throws Exception {
        No raiz = new No("A");
        Arvore arvore = new Arvore(raiz);

        arvore.inserir("A");
        arvore.inserir("B");
        arvore.inserir("D");
        arvore.inserir("E");
        arvore.inserir("C");
        arvore.inserir("F");

        System.out.println("Árvore binária em pré-ordem: ");
        arvore.preOrdem();
    }
}

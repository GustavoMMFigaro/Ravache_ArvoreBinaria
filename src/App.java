public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        System.out.println("Total de nós na árvore binária: " + arvore.contarNos());

        System.out.println("\nÁrvore escrita em pré-ordem: ");
        arvore.preOrdem();

        System.out.println("\nÁrvore escrita em em-ordem: ");
        arvore.emOrdem();
    }
}

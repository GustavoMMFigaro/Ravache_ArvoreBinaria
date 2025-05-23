public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();

        System.out.println("Total de nós na árvore binária: " + arvore.contarNos());

        System.out.println("\nÁrvore escrita em pré-ordem: ");
        arvore.preOrdem();

        System.out.println("\nÁrvore escrita em em-ordem: ");
        arvore.emOrdem();

        System.out.println("\nÁrvore escrita em pós-ordem: ");
        arvore.posOrdem();

        System.out.println("\nÁrvore escrita em em-nível: ");
        arvore.emNivel();
    }
}

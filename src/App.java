public class App {
    public static void main(String[] args) throws Exception {
        Arvore arvore = new Arvore();
        ArvoreAvl arvoreAvl = new ArvoreAvl();
        ArvoreRedBlack arvoreRB = new ArvoreRedBlack();

        System.out.println("Total de nós na árvore binária: " + arvore.contarNos());

        System.out.println("\nNúmero de nós folha da árvore binária(Iterativo): " + arvore.contarNosFolha());

        System.out.println("\nNúmero de nós folha da árvore binária(Recursivo): " + arvore.contarNosFolha2());

        System.out.println("\nNúmero de nós folha da árvore binária (Fila): " + arvore.contarNosFolha3());

        System.out.println("\nÁrvore escrita em pré-ordem: ");
        arvore.preOrdem();

        System.out.println("\nÁrvore escrita em em-ordem: ");
        arvore.emOrdem();

        System.out.println("\nÁrvore escrita em pós-ordem: ");
        arvore.posOrdem();

        System.out.println("\nÁrvore escrita em em-nível: ");
        arvore.emNivel();

        int[] chaves = {10, 20, 30, 40, 50, 25};

        for (int chave : chaves) {
            arvoreAvl.raiz = arvoreAvl.inserir(arvoreAvl.raiz, chave);
        }

        System.out.println("\nÁrvore AVL em em-ordem: ");
        arvoreAvl.printEmOrdemAvl(arvoreAvl.raiz);

        int[] chavesRB = {10, 20, 30, 15, 5, 25};
        for (int chaveRB : chavesRB) {
            arvoreRB.inserir(chaveRB);
        }

        System.out.println("\nArvore rubro-negra em ordem: ");
        arvoreRB.emOrdemRedBlack();

        arvoreRB.exclusao(15);
        arvoreRB.exclusao(10);

        System.out.println("\nArvore rubro-negra em ordem após exclusões: ");
        arvoreRB.emOrdemRedBlack();
    }
}

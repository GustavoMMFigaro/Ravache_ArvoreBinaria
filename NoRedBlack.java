enum Cor {
    vermelho, preto;
}

class NoRedBlack {
    int chave;
    NoRedBlack direita, esquerda, pai;
    Cor cor;

    NoRedBlack(int valor) {
        this.chave = chave;
        this.cor = Cor.vermelho;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
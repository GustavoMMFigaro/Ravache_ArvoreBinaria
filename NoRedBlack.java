enum Cor {
    vermelho, preto;
}

class NoRedBlack {
    int chaveRB;
    NoRedBlack direita, esquerda, pai;
    Cor cor;

    NoRedBlack(int chaveRB) {
        this.chaveRB = chaveRB;
        this.cor = Cor.vermelho;
        this.esquerda = null;
        this.direita = null;
        this.pai = null;
    }
}
public class ArvoreRedBlack {
    private NoRedBlack raiz;
    private NoRedBlack NoNull;

    public void rotacionarDireita(NoRedBlack y) {
        NoRedBlack x = y.esquerda;
        y.esquerda = x.direita;
        if (x.direita != null) {
            x.direita.pai = y;
        }

        x.pai = y.pai;

        if (y.pai == null) {
            raiz = x;
        } else if (y == y.pai.direita) {
            y.pai.direita = x;
        } else {
            y.pai.esquerda = x;
        }

        x.direita = y;
        y.pai = x;

    }


    public void rotacionarEsquerda(NoRedBlack x) {
        NoRedBlack y = x.direita;
        x.direita = y.esquerda;
        if (y.esquerda != null) {
            y.esquerda.pai = x;
        }

        y.pai = x.pai;

        if (x.pai == null) {
            raiz = y;
        } else if (x == x.pai.esquerda) {
            x.pai.esquerda = y;
        } else {
            x.pai.direita = y;
        }

        y.esquerda = x;
        x.pai = y;
    }


    public void inserir(int chave) {
        NoRedBlack no = new NoRedBlack(chave);
        no.esquerda = no.direita = no.pai = null;
        
        NoRedBlack y = null;
        NoRedBlack x = raiz;

        while (x != null) {
            y = x;
            if (no.chave < x.chave) {
                x = x.esquerda;
            } else {
                x = x.direita;
            }
        }

        no.pai = y;
        if (y == null) {
            raiz = no;
        } else if (no.chave < y.chave) {
            y.esquerda = no;
        } else {
            y.direita = no;
        }

        no.esquerda = null;
        no.direita = null;
        no.cor = Cor.vermelho;

        insertFix(no);
    }

    private void insertFix(NoRedBlack k) {
        while (k.pai != null && k.pai.cor == Cor.vermelho) {
            if (k.pai == k.pai.pai.esquerda) {
                NoRedBlack u = k.pai.pai.direita;
                if (u.cor == Cor.vermelho) {
                    k.pai.cor = Cor.preto;
                    u.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    k = k.pai.pai;
                } else {
                    if (k == k.pai.direita) {
                        k = k.pai;
                        rotacionarEsquerda(k);
                    }
                    k.pai.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    rotacionarDireita(k.pai.pai);
                }
            } else {
                NoRedBlack u = k.pai.pai.esquerda;
                if (u.cor == Cor.vermelho) {
                    k.pai.cor = Cor.preto;
                    u.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    k = k.pai.pai;
                } else {
                    if (k == k.pai.esquerda) {
                        k = k.pai;
                        rotacionarDireita(k);
                    }
                    k.pai.cor = Cor.preto;
                    k.pai.pai.cor = Cor.vermelho;
                    rotacionarEsquerda(k.pai.pai);
                }
            }
            if (k == raiz) break;
        }
        raiz.cor = Cor.preto;
    }

    private void transplante(NoRedBlack u, NoRedBlack v) {
        if (u.pai == null) {
            raiz = v;
        } else if (u == u.pai.esquerda) {
            u.pai.esquerda = v;
        } else u.pai.direita = v;
        v.pai = u.pai;
    }

    private NoRedBlack minimo(NoRedBlack no) {
        while (no.esquerda != null) {
            no = no.esquerda;
        }
        return no;
    }

    public void exclusao(int chave) {
        NoRedBlack z = searchtree(raiz, chave);
        if (z == null) {
            return;
        }

        NoRedBlack y = z;
        Cor yCorOriginal = y.cor;
        NoRedBlack x;

        if (z.esquerda == null) {
            x = z.direita;
            transplante(z, z.direita);
        } else if (z.direita == null) {
            x = z.esquerda;
            transplante(z, z.esquerda);
        } else {
            y = minimo(z.direita);
            yCorOriginal = y.cor;
            x = y.direita;
            if (y.pai == z) {
                x.pai = y;
            } else {
                transplante(y, y.direita);
                y.direita = z.direita;
                y.direita.pai = y;
            }
            transplante(z, y);
            y.esquerda = z.esquerda;
            y.esquerda.pai = y;
            y.cor = z. cor;
        }
        if (yCorOriginal == Cor.preto) {
            exclusaoFix(x);
        }
    }

    private void exclusaoFix(NoRedBlack x) {
        NoRedBlack w;
        while (x != raiz && x.cor == Cor.preto) {
            if (x == x.pai.esquerda) {
                w = x.pai.direita;
                if (w.cor == Cor.vermelho) {
                    w.cor = Cor.preto;
                    x.pai.cor = Cor.vermelho;
                    rotacionarEsquerda(x.pai);
                    w = x.pai.direita;
                }
                if (w.esquerda.cor == Cor.preto && w.direita.cor == Cor.preto) {
                    w.cor = Cor.vermelho;
                    x = x.pai;
                } else {
                    if (w.direita.cor == Cor.preto) {
                        w.esquerda.cor = Cor.preto;
                        w.cor = Cor.vermelho;
                        rotacionarDireita(w);
                        w = x.pai.direita;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.preto;
                    w.direita.cor = Cor.preto;
                    rotacionarEsquerda(x.pai);
                    x = raiz;
                } 
            } else {
                w = x.pai.esquerda;
                    if (w.cor == Cor.vermelho) {
                        w.cor = Cor.preto;
                        x.pai.cor = Cor.vermelho;
                        rotacionarDireita(x.pai);
                        w = x.pai.esquerda;
                    }
                    if (w.direita.cor == Cor.preto && w.esquerda.cor == Cor.preto) {
                        w.cor = Cor.vermelho;
                        x = x.pai;
                    } else {
                    if (w.esquerda.cor == Cor.preto) {
                        w.direita.cor = Cor.preto;
                        w.cor = Cor.vermelho;
                        rotacionarEsquerda(w);
                        w = x.pai.esquerda;
                    }
                    w.cor = x.pai.cor;
                    x.pai.cor = Cor.preto;
                    w.esquerda.cor = Cor.preto;
                    rotacionarDireita(x.pai);
                    x = raiz;
                }
            }
        }
    }

    private NoRedBlack searchtree(NoRedBlack no, int chave) {
        if (no == null || chave == no.chave) {
            return no;
        }
        if (chave < no.chave) {
            return searchtree(no.esquerda, chave);
        }
        return searchtree(no.direita, chave);
    }

    public void emOrdemRedBlack() {
        helperEmOrdemRedBlack(raiz);
        System.out.println();
    }

    private void helperEmOrdemRedBlack(NoRedBlack no) {
        if (no != null) {
            helperEmOrdemRedBlack(no.esquerda);
            String sufixoCor = (no.cor == Cor.vermelho) ? "R" : "B";
            System.out.println(no.chave + sufixoCor + " ");
            helperEmOrdemRedBlack(no.direita);
        }
    }
}

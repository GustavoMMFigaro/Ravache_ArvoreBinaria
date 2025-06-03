public class NoAvl {
    int valor;
    int altura; 
    NoAvl direita;
    NoAvl esquerda;

    public NoAvl(int valor) {
        this.valor = valor;
        this.altura = 1;
        esquerda = direita = null;
    }
}
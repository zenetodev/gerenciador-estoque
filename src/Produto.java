public class Produto {
    private int quantidade;
    private int valor;
    private int id;

    public Produto(int quantidade, int valor, int id) {
        this.quantidade = quantidade;
        this.valor = valor;
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getValor() {
        return valor;
    }

    public int getId() {
        return id;
    }

    public void adicionarQuantidade(int quantidade){
        this.quantidade += quantidade;
    }
}


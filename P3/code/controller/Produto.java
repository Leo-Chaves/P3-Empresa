package P3.code.controller;

public class Produto {
    public String nome;
    public double preco;
    public String codigo;
    private int estoque;

    //toString
    @Override
    public String toString(){
        return "Produto "+nome+", preço "+preco+", codigo "+codigo+", estoque "+estoque+".";
    }

    //construtor
    public Produto(String nome, double preco, String codigo, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.codigo = codigo;
        this.estoque = estoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public int getQtd() {
        return estoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void aumetarEstoque(int estoque) {
        this.estoque = estoque;
    }

    // metodos
    public void adicionarEstoque(int quantidade) {
        estoque += quantidade;
    }

    public void retirarEstoque(int quantidade) {
        if (estoque > quantidade) {
            estoque -= quantidade;
        } else {
            System.out.println("Estoque indisponivel");
        }
    }
}
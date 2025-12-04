package org.ex2.Model;

public class Produto {
    private String nome;
    private String codigo;
    private int qntestoque;

    public Produto() {
    }

    public Produto(String nome, String codigo, int qntestoque) {
        this.nome = nome;
        this.codigo = codigo;
        this.qntestoque = qntestoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getQntestoque() {
        return qntestoque;
    }

    public void setQntestoque(int qntestoque) {
        this.qntestoque = qntestoque;
    }
}

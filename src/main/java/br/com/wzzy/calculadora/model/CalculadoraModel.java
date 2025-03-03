package br.com.wzzy.calculadora.model;


public class CalculadoraModel {

    private final long id;
    private final String conteudo;

    public CalculadoraModel(long id, String conteudo) {
        this.id = id;
        this.conteudo = conteudo;
    }

    public long getId() {
        return id;
    }

    public String getConteudo() {
        return conteudo;
    }
}

package br.com.wzzy.calculadora.service;

import br.com.wzzy.calculadora.model.CalculadoraModel;

public interface CalculadoraService {


    Double soma(CalculadoraModel calculadoraModel) throws Exception;

    Double substracao(CalculadoraModel calculadoraModel) throws Exception;

    Double multiplicacao(CalculadoraModel calculadoraModel) throws Exception;

    Double divisao(CalculadoraModel calculadoraModel) throws Exception;

    Double media(CalculadoraModel calculadoraModel) throws Exception;

    Double raizQuadrada(CalculadoraModel calculadoraModel) throws Exception;
}

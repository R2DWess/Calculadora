package br.com.wzzy.calculadora.service;

import br.com.wzzy.calculadora.exception.UnsupportedMathOperationException;
import br.com.wzzy.calculadora.model.CalculadoraModel;
import br.com.wzzy.calculadora.util.ConvertToDoubleUtil;
import br.com.wzzy.calculadora.util.VerifyIsNumericUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraServiceImpl implements CalculadoraService{


    @Autowired
    private VerifyIsNumericUtil verifyIsNumericUtil;

    @Autowired
    private ConvertToDoubleUtil converterParaDouble;


    @Override
    public Double soma(CalculadoraModel calculadoraModel) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberOne())
                || !verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberTwo())) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double primeiroNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberOne());
        Double segundoNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberTwo());
        Double resultadoSoma = primeiroNumero + segundoNumero;

        return resultadoSoma;
    }

    @Override
    public Double substracao(CalculadoraModel calculadoraModel) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberOne())
            || !verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberTwo())) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double primeiroNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberOne());
        Double segundoNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberTwo());
        Double resultadoSubstracao = primeiroNumero - segundoNumero;

        return resultadoSubstracao;
    }

    @Override
    public Double multiplicacao(CalculadoraModel calculadoraModel) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberOne())
            || !verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberTwo())) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double primeiroNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberOne());
        Double segundoNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberTwo());
        Double resultadoMultiplicao = primeiroNumero * segundoNumero;

        return resultadoMultiplicao;
    }

    @Override
    public Double divisao(CalculadoraModel calculadoraModel) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberOne())
            || !verifyIsNumericUtil.isNumeric(calculadoraModel.getNumberTwo())) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double primeiroNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberOne());
        Double segundoNumero = converterParaDouble.convertToDouble(calculadoraModel.getNumberTwo());
        Double resultadoDivisao = primeiroNumero / segundoNumero;

        return resultadoDivisao;
    }

    @Override
    public Double media(CalculadoraModel calculadoraModel) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(calculadoraModel.getNumber())) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double mediaNumerica = converterParaDouble.convertToDouble(calculadoraModel.getNumber());
        Double resultadoMediaNumerica = mediaNumerica / 2;

        return resultadoMediaNumerica;
    }

    @Override
    public Double raizQuadrada(CalculadoraModel calculadoraModel) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(calculadoraModel.getNumber())) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        Double raizQuadrada = converterParaDouble.convertToDouble(calculadoraModel.getNumber());
        Double resultadoRaizQuadrada = Math.sqrt(raizQuadrada);

        return resultadoRaizQuadrada;
    }
}

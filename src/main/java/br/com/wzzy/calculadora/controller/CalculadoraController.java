package br.com.wzzy.calculadora.controller;

import br.com.wzzy.calculadora.exception.UnsupportedMathOperationException;
import br.com.wzzy.calculadora.util.ConvertToDoubleUtil;
import br.com.wzzy.calculadora.util.VerifyIsNumericUtil;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("v1/calculadora")
public class CalculadoraController {

    private final AtomicLong counter = new AtomicLong();
    private VerifyIsNumericUtil verifyIsNumericUtil;
    private ConvertToDoubleUtil converterParaDouble;

    @RequestMapping(value = "/soma/{numberOne}/{numberTwo}",
    method = RequestMethod.GET)
    public Double soma(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(numberOne) || !verifyIsNumericUtil.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return converterParaDouble.convertToDouble(numberOne) + converterParaDouble.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/substracao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double substracao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(numberOne) || !verifyIsNumericUtil.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return converterParaDouble.convertToDouble(numberOne) - converterParaDouble.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiplicacao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(numberOne) || !verifyIsNumericUtil.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return converterParaDouble.convertToDouble(numberOne) * converterParaDouble.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/divisao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double divisao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(numberOne) || !verifyIsNumericUtil.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return converterParaDouble.convertToDouble(numberOne) / converterParaDouble.convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/media/{numberOne}",
            method = RequestMethod.GET)
    public Double media(
            @PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return converterParaDouble.convertToDouble(numberOne) / 2;
    }

    @RequestMapping(value = "/raizQuadrada/{numberOne}",
            method = RequestMethod.GET)
    public Double raizQuadrada(
            @PathVariable(value = "numberOne") String number) throws Exception {
        if (!verifyIsNumericUtil.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return converterParaDouble.convertToDouble(String.valueOf(Math.sqrt(Double.parseDouble(number))));
    }

}

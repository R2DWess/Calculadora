package br.com.wzzy.calculadora.controller;

import br.com.wzzy.calculadora.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("v1/calculadora")
public class CalculadoraController {

    private final AtomicLong counter = new AtomicLong(); // <-- Função para gerar um novo id a cada requisição

    @RequestMapping(value = "/soma/{numberOne}/{numberTwo}",
    method = RequestMethod.GET)
    public Double soma(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/substracao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double substracao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiplicacao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/divisao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double divisao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/media/{numberOne}",
            method = RequestMethod.GET)
    public Double media(
            @PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }
        return convertToDouble(numberOne) / 2;
    }

    @RequestMapping(value = "/raizQuadrada/{numberOne}",
            method = RequestMethod.GET)
    public Double raizQuadrada(
            @PathVariable(value = "numberOne") String numberOne) throws Exception {
        if (!isNumeric(numberOne)) {
            throw new UnsupportedMathOperationException("Please set a numeric value");
        }

        return convertToDouble(String.valueOf(Math.sqrt(Double.parseDouble(numberOne))));
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}

package br.com.wzzy.calculadora.controller;

import br.com.wzzy.calculadora.model.CalculadoraModel;
import br.com.wzzy.calculadora.service.CalculadoraService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/calculadora")
public class CalculadoraController {

    private CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @RequestMapping(value = "/soma/{numberOne}/{numberTwo}",
    method = RequestMethod.GET)
    public Double soma(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        CalculadoraModel calculadoraModel = new CalculadoraModel(numberOne, numberTwo, null);

        return calculadoraService.soma(calculadoraModel);
    }


    @RequestMapping(value = "/substracao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double substracao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        CalculadoraModel calculadoraModel = new CalculadoraModel(numberOne, numberTwo, null);

        return calculadoraService.substracao(calculadoraModel);
    }

    @RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double multiplicacao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        CalculadoraModel calculadoraModel = new CalculadoraModel(numberOne, numberTwo, null);

        return calculadoraService.multiplicacao(calculadoraModel);
    }

    @RequestMapping(value = "/divisao/{numberOne}/{numberTwo}",
            method = RequestMethod.GET)
    public Double divisao(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo) throws Exception {

        CalculadoraModel calculadoraModel = new CalculadoraModel(numberOne, numberTwo, null);

        return calculadoraService.divisao(calculadoraModel);
    }

    @RequestMapping(value = "/media/{number}",
            method = RequestMethod.GET)
    public Double media(
            @PathVariable(value = "number") String number) throws Exception {

        CalculadoraModel calculadoraModel = new CalculadoraModel(null, null, number);

        return calculadoraService.media(calculadoraModel);
    }

    @RequestMapping(value = "/raizQuadrada/{number}",
            method = RequestMethod.GET)
    public Double raizQuadrada(
            @PathVariable(value = "number") String number) throws Exception {

        CalculadoraModel calculadoraModel = new CalculadoraModel(null, null, number);

        return calculadoraService.raizQuadrada(calculadoraModel);
    }

}

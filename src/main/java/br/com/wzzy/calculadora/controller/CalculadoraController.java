package br.com.wzzy.calculadora.controller;

import br.com.wzzy.calculadora.model.CalculadoraModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("v1/calculadora")
public class CalculadoraController {

    private static final String template = "Hello, %s!"; // <-- Definição padrão da mensagem retornada
    private final AtomicLong counter = new AtomicLong(); // <-- Função para gerar um novo id a cada requisição

    @GetMapping
    public CalculadoraModel saudacoes(@RequestParam(
            value = "name",
            defaultValue = "World") String name) {
        return new CalculadoraModel(counter.incrementAndGet(), String.format(template, name));
    }
}

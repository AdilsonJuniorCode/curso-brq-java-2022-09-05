package com.brq.ms01.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
* @ExtendedWith é uma anotação para permitir a execução e registro de testes unitarios
*  SpringExtension.class permite a integração do Spring boot com o junit
* */

@ExtendWith(SpringExtension.class)
public class CalculadoraUtilTests {

    private CalculadoraUtil calculadoraUtil = new CalculadoraUtil();

    @Test
    void somarTest(){
    int resultadoAtual = calculadoraUtil.somar(7,15);

    int resultadoEsperado = 22;

        assertEquals(resultadoEsperado, resultadoAtual);

    }

}

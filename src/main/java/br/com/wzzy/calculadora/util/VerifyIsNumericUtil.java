package br.com.wzzy.calculadora.util;

import org.springframework.stereotype.Component;

@Component
public class VerifyIsNumericUtil {

    public boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

}

package br.com.wzzy.calculadora.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertToDoubleUtil {

    @Autowired
    private VerifyIsNumericUtil verifyIsNumericUtil;

    public Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(verifyIsNumericUtil.isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

}

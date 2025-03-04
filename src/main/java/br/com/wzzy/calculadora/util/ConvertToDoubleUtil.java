package br.com.wzzy.calculadora.util;

public class ConvertToDoubleUtil {

    private VerifyIsNumericUtil verifyIsNumericUtil;

    public Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",",".");
        if(verifyIsNumericUtil.isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

}

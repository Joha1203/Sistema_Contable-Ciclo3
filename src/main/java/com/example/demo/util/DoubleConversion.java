package com.example.demo.util;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class DoubleConversion {

    public DoubleConversion() {
    }

    public String conversion(Double dinero){
        String pattern = "###,###,###.## COP";

        DecimalFormat myFormatter = new DecimalFormat(pattern, DecimalFormatSymbols.getInstance(Locale.ROOT));
        String output = myFormatter.format(dinero);
        return output;
    }
}

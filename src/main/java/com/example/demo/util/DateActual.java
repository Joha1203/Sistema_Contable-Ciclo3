package com.example.demo.util;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateActual {


    public DateActual(){

    }

    public Date local(){
        Date fecha = null;
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try{
            fecha = formato.parse(formatoFecha.format(LocalDateTime.now()));
        }catch(Exception e){
            System.err.println(e);
        }
        return fecha;
    }



}

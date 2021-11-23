package org.example.Models;

import java.util.Calendar;
import java.util.Random;

public class Client {
    private String name;
    private String dni;
    private Line line;

    public Client(String name, String dni,Line line){
        this.name = name;
        this.dni = dni;
        this.line = line;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public void makeCall(String lineNumber){
        String[] formattedLineNumber = lineNumber.split(" ",2);
        String region = formattedLineNumber[0];
        String number = formattedLineNumber[1];

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.MINUTE,12);

        if(region.compareTo("Local")==0){
            this.line.addCalls(new LocalCall(start,end,number));
        }else if (region.compareTo("National")==0){
            this.line.addCalls(new NationalCall(start,end,number));
        }else if(region.compareTo("International")==0){
            this.line.addCalls(new InternationalCall(start,end,number));
        }
    }
}

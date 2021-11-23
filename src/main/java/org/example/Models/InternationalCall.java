package org.example.Models;

import java.util.Calendar;

public class InternationalCall extends Call{

    public InternationalCall(Calendar start,Calendar end, String number){
        this.startCall = start;
        this.endCall = end;
        this.number = number;
    }
}

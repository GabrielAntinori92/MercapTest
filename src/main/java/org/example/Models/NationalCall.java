package org.example.Models;

import java.util.Calendar;

public class NationalCall extends Call{

    public NationalCall(Calendar start,Calendar end, String number){
        this.startCall = start;
        this.endCall = end;
        this.number = number;
    }

}

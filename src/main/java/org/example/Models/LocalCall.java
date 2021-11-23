package org.example.Models;

import java.util.Calendar;

public class LocalCall extends Call{

    public LocalCall(Calendar start,Calendar end, String number){
        this.startCall = start;
        this.endCall = end;
        this.number = number;
    }
}

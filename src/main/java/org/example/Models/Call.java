package org.example.Models;

import java.util.Calendar;

public abstract class Call {
    protected static Long id;
    protected Calendar startCall;
    protected Calendar endCall;
    protected Long duration;
    protected String number;

    public Calendar getStartCall() {
        return startCall;
    }

    public void setStartCall(Calendar startCall) {
        this.startCall = startCall;
    }

    public Calendar getEndCall() {
        return endCall;
    }

    public void setEndCall(Calendar endCall) {
        this.endCall = endCall;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long time) {
        this.duration = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

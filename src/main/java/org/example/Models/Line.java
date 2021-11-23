package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Line {
    //format for the lineNumber will be {Region space number} e.g: "Local 555-0011
    private String lineNumber;
    private Double monthly;
    private List<Call> calls;

    public Line(String lineNumber,Double monthly){
        this.lineNumber = lineNumber;
        this.monthly = monthly;
        this.calls = new ArrayList<>();
    }

    public Double getMonthly() {
        return monthly;
    }

    public void setMonthly(Double monthly) {
        this.monthly = monthly;
    }

    public String getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public void setCalls(List<Call> calls) {
        this.calls = calls;
    }

    public void addCalls(Call newCall){
        this.calls.add(newCall);
    }
}

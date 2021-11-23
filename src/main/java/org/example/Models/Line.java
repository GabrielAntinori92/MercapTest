package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Line {
    //format for the lineNumber will be {Region space number} e.g: "Local 555-0011
    private String lineNumber;
    private List<Call> calls;

    public Line(String lineNumber){
        this.lineNumber = lineNumber;
        this.calls = new ArrayList<>();
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

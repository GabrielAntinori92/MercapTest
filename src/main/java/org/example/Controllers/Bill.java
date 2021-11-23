package org.example.Controllers;


import org.example.Models.*;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bill {
    private Company company;
    private List<String> weekDays;
    private List<String> weekends;
    private DecimalFormat decimalFormat;

    public Bill(Company company){
        this.company = company;
        this.weekDays = new ArrayList<>();
        this.weekends = new ArrayList<>();
        this.weekDays.add("Mon");
        this.weekDays.add("Tue");
        this.weekDays.add("Wed");
        this.weekDays.add("Thu");
        this.weekDays.add("Fri");

        this.weekends.add("Sun");
        this.weekends.add("Sat");

        this.decimalFormat = new DecimalFormat("#.00");
    }

    public void generateBill(){
        double total;
        double cost;
        List<Client> clients = company.getClients();

        for(Client client : clients){
            total = 0;
            cost = 0;
            Line line = client.getLine();
            List<Call> clientCalls = line.getCalls();

            System.out.println("Nombre Empresa: " + company.getName());
            System.out.println("Cliente: " + client.getDni() + " - " + client.getName());
            System.out.println("Line: " + line.getLineNumber());
            System.out.println("Calls: ");

            for (Call call: clientCalls) {

                if(call instanceof LocalCall){
                    cost = calculateCost(call);
                    total += cost;
                    System.out.println("    Local " + "Duration: " + call.getDuration() + " Cost: $" + decimalFormat.format(cost));
                }else if(call instanceof NationalCall){
                    cost = calculateCost(call);
                    total += cost;
                    System.out.println("    National " + "Duration: " + call.getDuration() + " Cost: $" + decimalFormat.format(cost));
                }else if(call instanceof InternationalCall){
                    cost = calculateCost(call);
                    total += cost;
                    System.out.println("    International " + "Duration: " + call.getDuration() + " Cost: $" + decimalFormat.format(cost));
                }
            }
            System.out.println("Monthly: $" + line.getMonthly());
            total += line.getMonthly();
            System.out.println("Total: $" + decimalFormat.format(total));
        }
    }

    private double calculateCost(Call call){
        double cost = 0;

        String[] day = call.getStartCall().getTime().toString().split(" ",2);

        Date start = call.getStartCall().getTime();
        Date end = call.getEndCall().getTime();
        long milis = end.getTime() - start.getTime();
        long minutes = (milis / (1000*60)) % 60;
        call.setDuration(minutes);

        if(call instanceof LocalCall){
            System.out.println(day[0]);
            if(weekDays.contains(day[0])){
                String[] startArr = start.toString().split(" ",5);
                String[] endArr = end.toString().split(" ",5);

                String startHour = startArr[3];
                String endHour = endArr[3];

                LocalTime startTime = LocalTime.parse(startHour);
                LocalTime endTime = LocalTime.parse(endHour);
                LocalTime aHour = LocalTime.parse("08:00:00");
                LocalTime bHour = LocalTime.parse("20:00:00");
                boolean isInRange = (startTime.isAfter(aHour) && endTime.isBefore(bHour));

                if(isInRange){
                    cost = minutes * 0.2;
                }else{
                    cost = minutes * 0.1;
                }
            } else if(weekends.contains(day[0])){
                cost = minutes * 0.1;
            }
        }else if(call instanceof NationalCall){
            cost = minutes * 0.4;//improvement can be made
        }else if(call instanceof InternationalCall){
            cost = minutes * 0.8;// idem as above
        }

        return cost;
    }
}

package org.example.Models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private List<Client> clients;

    public Company(String name){
        this.name = name;
        this.clients = new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client newClient){
        this.clients.add(newClient);
    }
}

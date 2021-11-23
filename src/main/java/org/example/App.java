package org.example;

import org.example.Controllers.Bill;
import org.example.Models.Client;
import org.example.Models.Company;
import org.example.Models.Line;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Company company = new Company("Telesignal S.A.");
        Client client1 = new Client("Wilson","12345678",new Line("Local 555-0011",250.50));
        Client client2 = new Client("Sherlock","12346578", new Line("Local 555-0013",469.99));

        company.addClient(client1);
        company.addClient(client2);

        client1.makeCall("Local 555-0012");
        client2.makeCall("National 432-4400");
        client2.makeCall("International 01-000-2223");

        Bill bill = new Bill(company);

        bill.generateBill();
    }
}

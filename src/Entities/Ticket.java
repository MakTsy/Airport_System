package Entities;

import Entities.Client;
import Entities.Flight;

public class Ticket {
    Client client;
    Flight flight;
    String idTicket;
    String sitClass;
    boolean payed;

    public Ticket(Client client, Flight flight, String sitClass, String idTicket) {
        this.client = client;
        this.flight = flight;
        this.idTicket = idTicket;
        this.sitClass = sitClass;
    }
    public Ticket() {
        this.idTicket = "Empty";
    }


    public String getIdTicket() {
        return this.idTicket;
    }

    public String getSitClass() {
        return this.sitClass;
    }


    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public String getClientId() {
        return this.client.getIdClient();
    }

    public Client getClient() {
        return this.client;
    }

    public Flight getFlight() {
        return this.flight;
    }

    public boolean isPayed() {
        return this.payed;
    }
}

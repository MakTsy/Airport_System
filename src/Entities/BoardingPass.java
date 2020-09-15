package Entities;

public class BoardingPass {
    Client client;
    Flight flight;
    String sitClass;
    int seat;
    String gate;

    public BoardingPass(Ticket ticket, int seat, String gate) {
        this.gate = gate;
        this.seat = seat;
        this.client = ticket.getClient();
        this.flight = ticket.getFlight();
        this.sitClass = ticket.getSitClass();
    }

    public Client getClient() {
        return client;
    }

    public Flight getFlight() {
        return flight;
    }

    public int getSeat() {
        return seat;
    }

    public String getGate() {
        return gate;
    }

    public String getSitClass() {
        return sitClass;
    }
}

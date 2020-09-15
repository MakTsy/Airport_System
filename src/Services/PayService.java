package Services;

import Entities.Client;
import Entities.Ticket;

public class PayService {
    String[] paymentDetails;

    public void pay(Ticket ticket) {
        ticket.setPayed(true);
        this.getReceipt(ticket);
    }

    public void getReceipt(Ticket ticket) {
        System.out.println("PayService: \nPayment was successful\nClientId: " + ticket.getClientId() +
                "\nTicketId: " + ticket.getIdTicket() + "\nPaid up: " +
                ticket.getFlight().getClassPrice(ticket.getSitClass()));
    }

}

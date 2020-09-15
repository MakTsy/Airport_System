package Services;

import Entities.Client;
import Entities.Flight;
import Entities.Ticket;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    List<Ticket> tickets = new ArrayList<Ticket>();
    FlightControllService flightControllService;
    PayService payService;


    public BookingService(FlightControllService flightControllService, PayService payService) {
        this.flightControllService = flightControllService;
        this.payService = payService;
    }

    public String bookTicket(String departs, String arrive, String sitClass, Client client) {
        Flight flight = flightControllService.getFlight(departs,arrive);
        if(flight.getDeparting().equals("Empty")) {
            return "FlightError";
        }
        if(flight.getClassSit(sitClass) <= 0) {
            return "NoAvailableSit";
        }
        Ticket ticket = new Ticket(client, flight, sitClass,"qwe01");
        if (!pay(ticket)) {
            return "PayError";
        }
        flight.changeClassSit(sitClass);
        flightControllService.updateFlight(flight);
        tickets.add(ticket);

        return ticket.getIdTicket();
    }

    private boolean pay(Ticket ticket) {
        payService.pay(ticket);
        return ticket.isPayed();
    }

    public String getTicket(String idTicket) {
        for (Ticket ticket : tickets) {
            if(ticket.getIdTicket().equals(idTicket)) {
                return "Dear " + ticket.getClient().getName() + "!\nThis is your ticket on the flight from: " +
                        ticket.getFlight().getDeparting() + " to: " + ticket.getFlight().getArriving() +
                        " Be attentive, check-in starts at: " + ticket.getFlight().getCheckInOpens();
            }
        }
        return "No ticket";
    }

    public Ticket returnTicket(String idTicket) {
        for (Ticket ticket : tickets) {
            if(ticket.getIdTicket().equals(idTicket)) {
                return ticket;
            }
        }
        Ticket ticket = new Ticket();
        return ticket;
    }

}

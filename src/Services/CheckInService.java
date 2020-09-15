package Services;

import Entities.Passenger;
import Entities.Ticket;


import java.util.ArrayList;
import java.util.List;

public class CheckInService {
    BookingService bookingService;
    List<Passenger> passengers = new ArrayList<Passenger>();

    public CheckInService(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public String checkInClient(String ticketId) {
        Passenger passenger = new Passenger(this.bookingService.returnTicket(ticketId), "PG001", 15, "23DC");
        passengers.add(passenger);
        return passenger.getPassangerId();
    }

    public String getBoardingPass(String passengerId) {
        for (Passenger passenger : passengers) {
            if(passenger.getPassangerId().equals(passengerId)) {
                return "Your boarding pass: \nName: " + passenger.getBoardingPass().getClient().getName() +
                        "\nSeat: " + passenger.getBoardingPass().getSeat() + " " +
                        passenger.getBoardingPass().getSitClass() + " Gate: " + passenger.getBoardingPass().getGate() +
                        "\nBoarding time: " +
                        passenger.getBoardingPass().getFlight().getDepartureDate() + "\nFrom: " +
                        passenger.getBoardingPass().getFlight().getDeparting() + " To: " +
                        passenger.getBoardingPass().getFlight().getArriving();

            }
        }
        return "No such passenger";
    }

    public Passenger getPassenger(String passengerId) {
        for (Passenger passenger : passengers) {
            if (passenger.getPassangerId().equals(passengerId)) {
                return passenger;
            }
        }
        Passenger passenger = new Passenger();
        return passenger;
    }
}

package Services;

import Entities.Flight;

import java.util.ArrayList;
import java.util.List;

public class InfoService {
    List<Flight> flights = new ArrayList<Flight>();
    FlightControllService flightControllService;

    public InfoService(FlightControllService flightControllService) {
        this.flightControllService = flightControllService;
    }

    public String getInformationAboutFlights() {
        String shortInfoAboutFlight = "";
        for (Flight flight : flights) {
            shortInfoAboutFlight = shortInfoAboutFlight + " Departs from: " + flight.getDeparting() +
                    " At: " + flight.getDepartureDate().toString() + " \n" +
                    " Arrives at: " + flight.getArriving() + " At: " + flight.getArrivalDate() + " \n" +
                    " Status: " + flight.getStatus() + " \n";
        }
        return shortInfoAboutFlight;
    }

    public void updateInformationAboutFlights() {
        flights = flightControllService.getFlights();
    }
}

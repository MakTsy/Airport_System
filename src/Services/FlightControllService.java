package Services;

import Entities.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightControllService {
    List<Flight> flights = new ArrayList<Flight>();
    Flight emptyFlight = new Flight();

    public void addFlight(Flight flight) {
        this.flights.add(flight);
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void updateFlight(Flight flight) {
        int id = this.flights.indexOf(flight);
        this.flights.set(id, flight);
    }

    public void deleteFlight(Flight flight) {
        this.flights.remove(flight);
    }

    public Flight getFlight(String departs, String arrive) {
        for (Flight flight : flights) {
            if(flight.getArriving().equals(arrive) && flight.getDeparting().equals(departs)) {
                return flight;
            }
        }
        return this.emptyFlight;
    }

}

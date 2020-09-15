package Services;

import Entities.Baggage;
import Entities.Flight;
import Entities.Passenger;

public class AirTravelService {
    PassengerDeliveryService passengerDeliveryService;
    BaggageDeliveryService baggageDeliveryService;

    public AirTravelService(PassengerDeliveryService passengerDeliveryService,
                            BaggageDeliveryService baggageDeliveryService) {
        this.passengerDeliveryService = passengerDeliveryService;
        this.baggageDeliveryService = baggageDeliveryService;
    }

    public void depart() {
        System.out.println("AirTravelService: Departing...");
    }

    public void arrive() {
        System.out.println("AirTravelService: Arriving...");
    }
}

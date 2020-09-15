package Services;

import Entities.Baggage;

import java.util.ArrayList;
import java.util.List;

public class BaggageDeliveryService {
    CheckInBaggageService checkInBaggageService;
    List<Baggage> baggages = new ArrayList<>();

    public BaggageDeliveryService(CheckInBaggageService checkInBaggageService) {
        this.checkInBaggageService = checkInBaggageService;
        this.baggages = checkInBaggageService.getBaggages();
    }

    public List<Baggage> getBaggages() {
        return baggages;
    }

    public void deliverOnBoard() {
        System.out.println("BaggageDeliveryService: Baggage are in the plane");
    }

    public void deliverToTerminal() {
        System.out.println("BaggageDeliveryService: Baggage have been delivered to terminal");
    }
}

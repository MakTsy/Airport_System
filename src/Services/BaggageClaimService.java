package Services;

import Entities.Baggage;

import java.util.ArrayList;
import java.util.List;

public class BaggageClaimService {
    BaggageDeliveryService baggageDeliveryService;
    List<Baggage> baggages = new ArrayList<Baggage>();

    public BaggageClaimService(BaggageDeliveryService baggageDeliveryService) {
        this.baggageDeliveryService = baggageDeliveryService;
    }

    public void updateBaggage() {
        this.baggages = baggageDeliveryService.getBaggages();
    }

    public String dropBaggage(String passengerId) {
        for (Baggage baggage : baggages) {
            if( baggage.getBaggageOwnerId().equals(passengerId)) {
                return "This is your baggage bro!";
            }
        }
        return "No your baggage";
    }
}

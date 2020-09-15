package Services;

import Entities.Baggage;
import Entities.Passenger;

import java.util.ArrayList;
import java.util.List;

public class CheckInBaggageService {
    CheckInService checkInService;
    List<Baggage> baggages = new ArrayList<Baggage>();

    public CheckInBaggageService(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    public void checkInBaggage(String passengerId, float baggageWeight) {
        Baggage baggage = new Baggage(baggageWeight, passengerId);
        baggages.add(baggage);
    }

    public String getBaggageTag(String passengerId) {
        for (Baggage baggage : baggages) {
            if( baggage.getBaggageOwnerId().equals(passengerId)) {
                return "Baggage Tag: \nOwnerId: " + baggage.getBaggageOwnerId() + "\nFrom : " +
                        checkInService.getPassenger(passengerId).getBoardingPass().getFlight().getDeparting() + " To: "
                        + checkInService.getPassenger(passengerId).getBoardingPass().getFlight().getArriving();
            }
        }
        return "No your baggage";
    }

    public List<Baggage> getBaggages() {
        return baggages;
    }
}

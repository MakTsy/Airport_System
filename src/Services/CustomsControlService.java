package Services;

import Entities.Passenger;

public class CustomsControlService {
    CheckInService checkInService;

    public CustomsControlService(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    public String declarateAndCheck(String passengerId, String description) {
        this.checkInService.getPassenger(passengerId).setCustomsControlCheck("Passed");
        return "Passanger: " + passengerId + " you have successfully declarated " + description;
    }

    public String skipAndCheck(String passengerId) {
        this.checkInService.getPassenger(passengerId).setCustomsControlCheck("Passed");
        return "Passanger: " + passengerId + " you have successfully passed custom control without declaration";
    }

}

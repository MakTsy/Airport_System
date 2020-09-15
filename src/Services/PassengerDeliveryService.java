package Services;

import Entities.Passenger;

public class PassengerDeliveryService {
    CheckInService checkInService;


    public PassengerDeliveryService(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    public String deliverOnBoard(String passengerId) {
        return "Wellcome on the board! " +
                this.checkInService.getPassenger(passengerId).getBoardingPass().getClient().getName();
    }

    public String deliverToTerminal(String passengerId) {
        return "Wellcome in " +
                this.checkInService.getPassenger(passengerId).getBoardingPass().getFlight().getArriving() + ", " +
                this.checkInService.getPassenger(passengerId).getBoardingPass().getClient().getName() + "!";
    }
}

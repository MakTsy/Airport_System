package Services;

public class BorderControlService {

    CheckInService checkInService;

    public BorderControlService(CheckInService checkInService) {
        this.checkInService = checkInService;
    }

    public String checkPassanger(String passengerId) {
        this.checkInService.getPassenger(passengerId).setPassportControlCheck("Passed");
        return "Passanger: " + passengerId + " you have successfully passed passport control";
    }
}

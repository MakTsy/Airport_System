package Services;


public class PreFlightInspectionService {
    CheckInService checkInService;

    public PreFlightInspectionService(CheckInService checkInService) {
        this.checkInService =  checkInService;
    }

    public String inspect( String passengerId) {
        this.checkInService.getPassenger(passengerId).setPreFlightCheck("Passed");
        return "Passanger: " + passengerId + " you have successfully passed Security control";
    }
}

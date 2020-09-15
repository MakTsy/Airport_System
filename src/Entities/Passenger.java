package Entities;


public class Passenger {
    String passangerId;
    Baggage baggage;
    BoardingPass boardingPass;
    String passportControlCheck;
    String customsControlCheck;
    String preFlightCheck;

    public Passenger(Ticket ticket, String passangerId, int seat, String gate) {
        this.passangerId = passangerId;
        this.boardingPass = new BoardingPass(ticket, seat, gate);
    }

    public Passenger() {
        this.passangerId = "Empty";
    }

    public String getPassangerId() {
        return passangerId;
    }

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public void setCustomsControlCheck(String customsControlCheck) {
        this.customsControlCheck = customsControlCheck;
    }

    public void setPassportControlCheck(String passportControlCheck) {
        this.passportControlCheck = passportControlCheck;
    }

    public void setPreFlightCheck(String preFlightCheck) {
        this.preFlightCheck = preFlightCheck;
    }
}

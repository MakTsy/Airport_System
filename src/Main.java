import Entities.Baggage;
import Entities.Client;
import Entities.Flight;
import Services.*;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
    // environment
        Flight flightKyivLondon = new Flight("Kyiv", "London","14.09.2020 18:50",
                "14.09.2020 19:50", "14.09.2020 15:50", "On-time",
                20, 30, 20, 60, 20, 40);
        Flight flightKyivOslo = new Flight("Kyiv", "Oslo","14.09.2020 17:50",
                "14.09.2020 18:50", "14.09.2020 14:50", "On-time",
                20, 30, 20, 60, 20, 40);
        FlightControllService flightControllService = new FlightControllService();
        flightControllService.addFlight(flightKyivLondon);
        flightControllService.addFlight(flightKyivOslo);

        PayService payService = new PayService();
        InfoService infoService = new InfoService(flightControllService);
        BookingService bookingService = new BookingService(flightControllService, payService);
        CheckInService checkInService = new CheckInService(bookingService);
        CheckInBaggageService checkInBaggageService = new CheckInBaggageService(checkInService);
        CustomsControlService customsControlService = new CustomsControlService(checkInService);
        BorderControlService borderControlService = new BorderControlService(checkInService);
        PreFlightInspectionService preFlightInspectionService = new PreFlightInspectionService(checkInService);
        PassengerDeliveryService passengerDeliveryService = new PassengerDeliveryService(checkInService);
        BaggageDeliveryService baggageDeliveryService = new BaggageDeliveryService(checkInBaggageService);
        BaggageClaimService baggageClaimService = new BaggageClaimService(baggageDeliveryService);
        AirTravelService airTravelService = new AirTravelService(passengerDeliveryService, baggageDeliveryService);

        Client client = new Client("Vasya", "Petrov", "VP001");
        ClientService clientService = new ClientService(client, infoService, bookingService, checkInService,
                checkInBaggageService, customsControlService, borderControlService, preFlightInspectionService,
                passengerDeliveryService, baggageClaimService);

     // Client story
        clientService.getInformationAboutFlights();
        String ticketID = clientService.bookTicket("Kyiv","London", "Econom");
        String passengerId = clientService.checkIn(ticketID);
        clientService.checkInBaggage(passengerId, 8.6f);
        clientService.passCustomsControlRed(passengerId, "10000$");
        clientService.passPassportControl(passengerId);
        clientService.passSecurityCheck(passengerId);
        clientService.comeOnBoard(passengerId);
        baggageDeliveryService.deliverOnBoard();
        airTravelService.depart();
        airTravelService.arrive();
        baggageDeliveryService.deliverToTerminal();
        baggageClaimService.updateBaggage();
        clientService.getOffBoard(passengerId);
        clientService.passPassportControl(passengerId);
        clientService.pickUpLuggage(passengerId);
        clientService.passCustomsControlGreen(passengerId);

     //The end..
    }
}

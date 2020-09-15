package Services;

import Entities.Baggage;
import Entities.Client;

public class ClientService {
    Client client;

    InfoService infoService;
    BookingService bookingService;
    CheckInService checkInService;
    CheckInBaggageService checkInBaggageService;
    CustomsControlService customsControlService;
    BorderControlService borderControlService;
    PreFlightInspectionService preFlightInspectionService;
    PassengerDeliveryService passengerDeliveryService;
    BaggageClaimService baggageClaimService;

    public ClientService(Client client, InfoService infoService, BookingService bookingService,
                         CheckInService checkInService, CheckInBaggageService checkInBaggageService,
                         CustomsControlService customsControlService, BorderControlService borderControlService,
                         PreFlightInspectionService preFlightInspectionService,
                         PassengerDeliveryService passengerDeliveryService,
                                 BaggageClaimService baggageClaimService) {
        this.client = client;
        showClient();
        this.infoService = infoService;
        this.bookingService = bookingService;
        this.checkInService = checkInService;
        this.checkInBaggageService = checkInBaggageService;
        this.customsControlService = customsControlService;
        this.borderControlService = borderControlService;
        this.preFlightInspectionService = preFlightInspectionService;
        this.passengerDeliveryService = passengerDeliveryService;
        this.baggageClaimService = baggageClaimService;
    }

    public void showClient() {
       System.out.println(this.client.sayGreeting());
    }

    public void getInformationAboutFlights() {
        System.out.println(client.getName()+ ": I wanna know what flights do you have");
        infoService.updateInformationAboutFlights();
        System.out.print("InfoService:" + "\n" + infoService.getInformationAboutFlights());
    }

    public String bookTicket(String departs, String arrive, String sitClass) {
        System.out.println(client.getName()+ ": I will book ticket to "+ arrive);
        String ticketId = bookingService.bookTicket(departs, arrive, sitClass, client);
        System.out.println("BookingService:" + "\n" + bookingService.getTicket(ticketId));
        return ticketId;
    }

    public String checkIn(String ticketId) {
        System.out.println(client.getName()+ ": Now, I am going to check-in");
        String passengerId =  checkInService.checkInClient(ticketId);
        System.out.println("CheckInService:" + "\n" + checkInService.getBoardingPass(passengerId));
        return passengerId;
    }

    public void checkInBaggage(String passengerId, float baggageWeight) {
        System.out.println(client.getName()+ ": I need to check-in my heavy baggage");
        checkInBaggageService.checkInBaggage(passengerId, baggageWeight);
        System.out.println("checkInBaggageService:" + "\n" + checkInBaggageService.getBaggageTag(passengerId));
    }

    public void passCustomsControlRed(String passengerId, String description) {
        System.out.println(client.getName()+ ": I have to declare my cash at $ 10,000");
        System.out.println("CustomsControlService:" + "\n" + customsControlService.declarateAndCheck(passengerId, description));
    }

    public void passCustomsControlGreen(String passengerId) {
        System.out.println(client.getName()+ ": I have nothing to declarate");
        System.out.println("CustomsControlService:" + "\n" + customsControlService.skipAndCheck(passengerId));
    }

    public void passPassportControl(String passengerId) {
        System.out.println(client.getName()+ ": Now, just pass pasport control");
        System.out.println("PasportControlService:" + "\n" + borderControlService.checkPassanger(passengerId));
    }

    public void passSecurityCheck(String passengerId) {
        System.out.println(client.getName()+ ": And the last check is security control");
        System.out.println("PreFlightInspectionService:" + "\n" + preFlightInspectionService.inspect(passengerId));
    }

    public void comeOnBoard(String passengerId) {
        System.out.println(client.getName()+ ": I need to come on board");
        System.out.println("PasengerDeliveryService:" + "\n" + passengerDeliveryService.deliverOnBoard(passengerId));
    }

    public void getOffBoard(String passengerId) {
        System.out.println(client.getName()+ ": Yeees! I am arrived.");
        System.out.println("PasengerDeliveryService:" + "\n" + passengerDeliveryService.deliverToTerminal(passengerId));
    }

    public void pickUpLuggage(String passengerId) {
        System.out.println(client.getName()+ ": I wanna pick up my laggage");
        System.out.println("BaggageClaimService:" + "\n" + baggageClaimService.dropBaggage(passengerId));
    }
}
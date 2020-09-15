package Entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Flight {
    Date departureDate;
    Date arrivalDate;
    String departing;
    String arriving;
    Date checkInOpens;
    String status;
    HashMap<String, Integer> classSit = new HashMap<String, Integer>();
    HashMap<String, Integer> classPrice = new HashMap<String, Integer>();


    public Flight(String departing, String arriving, String departureDate, String arrivalDate, String checkInOpens,
                  String status, int economySit, int economyPrice, int businessSit, int businessPrice,
                  int firstSit, int firstPrice) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy kk:mm");
        this.departureDate = format.parse(departureDate);
        this.arrivalDate = format.parse(arrivalDate);
        this.departing = departing;
        this.arriving = arriving;
        this.checkInOpens = format.parse(checkInOpens);
        this.status = status;
        this.classSit.put("Econom", economySit);
        this.classSit.put("First", firstSit);
        this.classSit.put("Business", businessSit);
        this.classPrice.put("Econom", economyPrice);
        this.classPrice.put("First", firstPrice);
        this.classPrice.put("Business", businessPrice);
    }

    public Flight() {
        this.departing = "Empty";
    }

    public void changeStatus(){
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public Date getCheckInOpens() {
        return checkInOpens;
    }

    public String getArriving() {
        return arriving;
    }

    public String getDeparting() {
        return departing;
    }


    public String getStatus() {
        return status;
    }

    public float getClassPrice(String clas) {
        return classPrice.get(clas);
    }

    public int getClassSit(String clas) {
        return classSit.get(clas);
    }

    public void changeClassSit(String clas) {
        this.classSit.put(clas, this.classSit.get(clas) -1);
    }
}

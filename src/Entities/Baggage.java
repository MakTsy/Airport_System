package Entities;

public class Baggage {
    float baggageWeight;
    String baggageOwnerId;

    public Baggage(float weight, String baggageOwnerId) {
        this.baggageWeight = weight;
        this.baggageOwnerId = baggageOwnerId;
    }

    public String getBaggageOwnerId() {
        return this.baggageOwnerId;
    }
}

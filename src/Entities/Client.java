package Entities;

public class Client {
    String idClient;
    String name;
    String surname;

    public Client(String name, String surname, String idClient) {
        this.name = name;
        this.surname = surname;
        this.idClient = idClient;
    }

    public String sayGreeting() {
        return "Hello! I am new here and i love travelling. My name is " + this.name + " " + this.surname;
    }

    public String getName() {
        return this.name;
    }

    public String getIdClient() {
        return this.idClient;
    }
}

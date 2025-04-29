package src.proj;

public class Customer {
    private String name;
    private int ticketNumber;

    // Constructor
    public Customer(String name, int ticketNumber) {
        this.name = name;
        this.ticketNumber = ticketNumber;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int geTicketNumber() {
        return ticketNumber;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
}

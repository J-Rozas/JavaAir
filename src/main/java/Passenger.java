public class Passenger extends Person {

    private final int numberOfBags;
    private boolean flightStatus;

    public Passenger(String name, int numberOfBags) {
        super(name);
        this.numberOfBags = numberOfBags;
        this.flightStatus = false;
    }

    public int getNumberOfBags() {
        return this.numberOfBags;
    }

    public boolean getFlightStatus() {
        return this.flightStatus;
    }

    public void setFlightStatus(boolean status) {
        this.flightStatus = status;
    }
}

public class Passenger extends Person {

    private final int numberOfBags;
    private boolean flightStatus;
    private int seatNumber;

    public Passenger(String name, int numberOfBags) {
        super(name);
        this.numberOfBags = numberOfBags;
        this.flightStatus = false;
        this.seatNumber = 0;
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

    public int getSeatNumber() {
        return this.seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}

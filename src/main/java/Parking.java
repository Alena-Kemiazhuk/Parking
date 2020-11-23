import java.util.ArrayList;

public class Parking {

    private ArrayList<ParkingPlace> parkingPlaces = new ArrayList<ParkingPlace>();
    public static final int QUANTITY_PLACES = 5;

    public Parking() {
        parkingPlaces.add(new ParkingPlace(1));
        parkingPlaces.add(new ParkingPlace(2));
        parkingPlaces.add(new ParkingPlace(3));
        parkingPlaces.add(new ParkingPlace(4));
        parkingPlaces.add(new ParkingPlace(5));
    }

    public ArrayList<ParkingPlace> getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(ArrayList<ParkingPlace> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }


    public synchronized ParkingPlace freeParkingPlace() {
        for (ParkingPlace parkingPlaceOne : this.parkingPlaces) {
            if (parkingPlaceOne.getCar() == null) {
                return parkingPlaceOne;
            }
        }
        return null;
    }

}

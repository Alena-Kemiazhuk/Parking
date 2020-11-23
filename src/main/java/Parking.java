import java.util.HashMap;
import java.util.Map;

public class Parking {

    private Map<ParkingPlace, Boolean> parkingPlaces = new HashMap<ParkingPlace, Boolean>();
    public static final int QUANTITY_PLACES = 5;

    public Parking() {
        for(int i = 1; i <= QUANTITY_PLACES; i++) {
            parkingPlaces.put(new ParkingPlace(1), false);
        }
    }

    public Map<ParkingPlace, Boolean> getParkingPlaces() {
        return parkingPlaces;
    }


    public synchronized ParkingPlace freeParkingPlace() {
        var place = parkingPlaces.entrySet().stream().filter(item -> !item.getValue()).findFirst();
        if(place.isPresent()) {
            place.get().setValue(true);
            return place.get().getKey();
        }
        return null;
    }

}

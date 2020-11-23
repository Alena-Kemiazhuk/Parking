public class Car {

    String name;
    ParkingPlace parkingPlace;

    public Car (String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParkingPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public boolean park(Parking parking) {
        ParkingPlace parkingPlace = parking.freeParkingPlace();
        if (parkingPlace  == null) {
            return false;
        } else {
            parkingPlace.setCar(this);
            this.parkingPlace = parkingPlace;
            return true;
        }
    }

    public void exit() {
        this.parkingPlace.setCar(null);
        this.parkingPlace = null;
    }

    public String toString() {
        return parkingPlace != null ? name + " on " + parkingPlace.getNumberOfPlace() : name + " leave parking";
    }

}

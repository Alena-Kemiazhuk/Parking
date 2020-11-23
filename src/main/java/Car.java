public class Car {

    String name;
    ParkingPlace parkingPlace;

    public Car(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParkingPlace(ParkingPlace parkingPlace) {
        this.parkingPlace = parkingPlace;
    }

    public void park(final Parking parking) {
        final Car car = this;
        new Thread(new Runnable() {
            public void run() {
                try {
                    int attempts = 0;
                    boolean parked = false;
                    while(attempts < Parking.QUANTITY_PLACES) {
                        parked = car.parkCar(parking);
                        if(parked) {
                            break;
                        }
                        Thread.sleep(1000);
                        attempts++;

                    }
                    if(parked) {
                        System.out.println("Car parked: " + car);
                        Thread.sleep(1000);
                        car.exit();
                        System.out.println("Car exit: " + car);
                    }else {
                        System.out.println("Car not parked: " + car);
                        Thread.sleep(1000);
                    }
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private Boolean parkCar(Parking parking) {
        ParkingPlace parkingPlace = parking.freeParkingPlace();
        if(parkingPlace == null) {
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

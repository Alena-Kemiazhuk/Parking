import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        final Parking parking = new Parking();
        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new Car("one"));
        cars.add(new Car("two"));
        cars.add(new Car("three"));
        cars.add(new Car("four"));
        cars.add(new Car("five"));
        cars.add(new Car("six"));
        cars.add(new Car("seven"));
        for (final Car car : cars) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        int attempts = 0;
                        boolean parked = false;
                        while (attempts < Parking.QUANTITY_PLACES) {
                            parked = car.park(parking);
                            if (parked) {
                                break;
                            }
                            Thread.sleep(1000);
                            attempts++;

                        }
                        if (parked) {
                            System.out.println("Car parked: " + car);
                            Thread.sleep(1000);
                            car.exit();
                            System.out.println("Car exit: " + car);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
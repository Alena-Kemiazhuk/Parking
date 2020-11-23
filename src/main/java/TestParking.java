import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParking {
    final Parking parking = new Parking();

    @DataProvider(name = "cars", parallel = true)
    public Object[][] createCars() {
        return new Object[][]{{new Car("one")}, {new Car("two")}, {new Car("three")}, {new Car("four")}, {new Car("five")}, {new Car("six")},
                              {new Car("seven")}};
    }

    @Test(dataProvider = "cars")
    public void checkAddingCars(Car car) {
        car.park(parking);
    }

}

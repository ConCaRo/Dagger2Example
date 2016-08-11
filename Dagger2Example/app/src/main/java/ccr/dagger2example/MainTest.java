package ccr.dagger2example;

/**
 * Created by DELL on 8/8/2016.
 */
public class MainTest {
    public static void main(String[] args) {


        Vehicle vehicle;

       VehicleComponent component = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();
//
        vehicle = component.provideVehicle();

        System.out.print(String.valueOf(vehicle.getSpeed()));
    }
}

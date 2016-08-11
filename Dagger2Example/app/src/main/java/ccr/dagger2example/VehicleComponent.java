package ccr.dagger2example;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by DELL on 8/8/2016.
 */
@Singleton
@Component(modules = {
        VehicleModule.class
        })
public interface VehicleComponent {

    Vehicle provideVehicle();
}

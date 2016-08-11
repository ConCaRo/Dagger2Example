package ccr.dagger2example;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by DELL on 8/8/2016.
 */
@Module
public class VehicleModule {
    @Provides
    @Singleton
    Motor provideMotor(Motor motor) {
        return new Motor();
    }

    @Provides
    @Singleton
    Vehicle provideVehicle() {
        return new Vehicle(new Motor());
    }
}

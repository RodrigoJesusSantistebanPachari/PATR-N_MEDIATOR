package patron_mediator.mediator;

import patron_mediator.components.Heater;
import patron_mediator.components.Motor;
import patron_mediator.components.Sensor;
import patron_mediator.components.Valve;

public class DelicatesMediator extends Mediator {

    private Motor motor;
    private Sensor sensor;
    private Heater heater;

    public DelicatesMediator(Valve valve, Motor motor, Sensor sensor, Heater heater) {
        super.valve = valve;
        this.motor = motor;
        this.sensor = sensor;
        this.heater = heater;
    }

    @Override
    public void start() {
        valve.openValve();
    }

    @Override
    public void valveOpened() {
        motor.rotateDrum(500);
    }

    @Override
    public void drumSpeedReached() {
        sensor.setRequiredTemp(30);
        heater.setTemperature(30);
    }

    @Override
    public void temperatureSet(int temperature) {
        sensor.checkTemperatureHighEnough(temperature);
    }

    @Override
    public void temperatureReached() {
        motor.stopMotor();
    }

}

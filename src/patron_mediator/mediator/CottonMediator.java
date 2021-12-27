package patron_mediator.mediator;

import patron_mediator.components.Heater;
import patron_mediator.components.Motor;
import patron_mediator.components.Sensor;
import patron_mediator.components.Valve;

public class CottonMediator extends Mediator {

    private Motor motor;
    private Sensor sensor;
    private Heater heater;

    public CottonMediator(Valve valve, Motor motor, Sensor sensor, Heater heater) {
        super.valve = valve;
        this.motor = motor;
        this.sensor = sensor;
        this.heater = heater;
    }

    @Override
    public void valveOpened() {
        motor.rotateDrum(700);
    }

    @Override
    public void drumSpeedReached() {
        sensor.setRequiredTemp(40);
        heater.setTemperature(40);
    }

    @Override
    public void temperatureSet(int temp) {
        sensor.checkTemperatureHighEnough(temp);
    }

    @Override
    public void temperatureReached() {
        motor.stopMotor();
    }

}

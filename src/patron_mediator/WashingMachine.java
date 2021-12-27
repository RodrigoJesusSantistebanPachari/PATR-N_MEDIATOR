package patron_mediator;

import patron_mediator.components.Heater;
import patron_mediator.components.Motor;
import patron_mediator.components.Sensor;
import patron_mediator.components.Valve;
import patron_mediator.mediator.CottonMediator;

public class WashingMachine {

    private CottonMediator mediator;

    public WashingMachine() {
        Valve valve = new Valve();
        Motor motor = new Motor();
        Sensor sensor = new Sensor();
        Heater heater = new Heater();
        mediator = new CottonMediator(valve, motor, sensor, heater);
        setMediator(valve, motor, sensor, heater);
    }

    public void start() {
        mediator.start();
    }

    private void setMediator(Valve valve, Motor motor, Sensor sensor, Heater heater) {
        valve.setMediator(mediator);
        motor.setMediator(mediator);
        sensor.setMediator(mediator);
        heater.setMediator(mediator);
    }

}

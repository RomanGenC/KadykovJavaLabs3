interface Command {
    void execute();
}

class Light {
    public void turnOn() {
        System.out.println("Свет включен");
    }

    public void turnOff() {
        System.out.println("Свет выключен");
    }
}

class Thermostat {
    public void setTemperature(int temperature) {
        System.out.println("Температура установлен в " + temperature + "°C");
    }
}

class TurnOnLightsCommand implements Command {
    private Light light;

    public TurnOnLightsCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

class TurnOffLightsCommand implements Command {
    private Light light;

    public TurnOffLightsCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOff();
    }
}

class SetTemperatureCommand implements Command {
    private Thermostat thermostat;
    private int temperature;

    public SetTemperatureCommand(Thermostat thermostat, int temperature) {
        this.thermostat = thermostat;
        this.temperature = temperature;
    }

    @Override
    public void execute() {
        thermostat.setTemperature(temperature);
    }
}

class SmartHomeController {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("Не установлена команда");
        }
    }
}

public class Lab6Task4 {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();

        Command turnOnLights = new TurnOnLightsCommand(livingRoomLight);
        Command turnOffLights = new TurnOffLightsCommand(livingRoomLight);
        Command setTemperature = new SetTemperatureCommand(thermostat, 22);

        SmartHomeController controller = new SmartHomeController();

        controller.setCommand(turnOnLights);
        controller.executeCommand();

        controller.setCommand(setTemperature);
        controller.executeCommand();

        controller.setCommand(turnOffLights);
        controller.executeCommand();
    }
}

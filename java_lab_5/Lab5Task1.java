public class Lab5Task1 {
    public static void main(String[] args) {
        Vehicle car = new Car("Автомобиль");
        Vehicle bicycle = new Bicycle("Велосипед");
        Vehicle boat = new Boat("Лодка");

        car.move();
        bicycle.move();
        boat.move();

        ElectricVehicle electricCar = new ElectricCar("Электромобиль", 50);
        ElectricVehicle electricBicycle = new ElectricBicycle("Электровелосипед", 20);

        electricCar.move();
        electricBicycle.move();

        electricCar.chargeBattery();
        electricBicycle.chargeBattery();

        electricCar.move();
        electricBicycle.move();
    }
}

abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {this.name = name;}

    public abstract void move();
}

class Car extends Vehicle {

    public Car(String name) {super(name);}

    @Override
    public void move() {
        System.out.println(name + " едет по дороге.");
    }
}

class Bicycle extends Vehicle {

    public Bicycle(String name) {super(name);}

    @Override
    public void move() {
        System.out.println(name + " едет по велосипедной дорожке.");
    }
}

class Boat extends Vehicle {

    public Boat(String name) {super(name);}

    @Override
    public void move() {
        System.out.println(name + " плывет по воде.");
    }
}

abstract class ElectricVehicle extends Vehicle {
    protected int batteryLevel;

    public ElectricVehicle(String name, int batteryLevel) {
        super(name);
        this.batteryLevel = batteryLevel;
    }

    public void chargeBattery() {
        batteryLevel = 100;
        System.out.println(name + " заряжен до 100%.");
    }

    protected boolean isBatteryEnough(int requiredCharge) {
        if (batteryLevel >= requiredCharge) {
            return true;
        } else {
            System.out.println(name + " не может двигаться, батарея разряжена.");
            return false;
        }
    }
}

class ElectricCar extends ElectricVehicle {

    public ElectricCar(String name, int batteryLevel) {
        super(name, batteryLevel);
    }

    @Override
    public void move() {
        int requiredCharge = 10;
        if (isBatteryEnough(requiredCharge)) {
            System.out.println(name + " едет по дороге на электричестве. Текущий заряд: " + batteryLevel + "%.");
            batteryLevel -= requiredCharge;
            System.out.println("Заряд после движения: " + batteryLevel + "%.");
        }
    }
}

class ElectricBicycle extends ElectricVehicle {

    public ElectricBicycle(String name, int batteryLevel) {
        super(name, batteryLevel);
    }

    @Override
    public void move() {
        int requiredCharge = 5;
        if (isBatteryEnough(requiredCharge)) {
            System.out.println(name + " едет по велосипедной дорожке на электричестве. Текущий заряд: " + batteryLevel + "%.");
            batteryLevel -= requiredCharge;
            System.out.println("Заряд после движения: " + batteryLevel + "%.");
        }
    }
}

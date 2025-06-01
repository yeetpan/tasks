// Working of Abstraction in Java
abstract class ElectronicDevice {
    abstract void turnOn();
    abstract void turnOff();
}

// Concrete class implementing the abstract methods
class TVRemote extends ElectronicDevice {
    void turnOn() {
        System.out.println("TV is turned ON.");
    }

    void turnOff() {
        System.out.println("TV is turned OFF.");
    }
}

// Main class to demonstrate abstraction
public class Abstr {
    public static void main(String[] args) {
        ElectronicDevice remote = new TVRemote();
        remote.turnOn();
        remote.turnOff();
    }
}
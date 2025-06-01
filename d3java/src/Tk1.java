class ElectronicDevice {
    public void TurnOn() {
        System.out.println("Device Turned ON");
    }

    public void TurnOff() {
        System.out.println("Device Turned OFF");
    }
}

class BTspeaker extends ElectronicDevice {
    @Override
    public void TurnOn() {
        System.out.println("Bluetooth device is ready to pair");
    }

    @Override
    public void TurnOff() {
        System.out.println("Bluetooth device is turned off");
    }
}

public class Tk1 {
    public static void main(String[] args) {
        ElectronicDevice device = new BTspeaker(); // Polymorphism
        device.TurnOn();
        device.TurnOff();
    }
}

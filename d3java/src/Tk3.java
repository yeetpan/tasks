// Abstract class
abstract class Machine {
    abstract void operate();
    void powerOn() {
        System.out.println("Powering on machine...");
    }
}

// Interface implementation
interface Maintainable {
    void service();
}

class Robot extends Machine implements Maintainable {
    void operate() {
        System.out.println("Robot is operating.");
    }

    public void service() {
        System.out.println("Robot is being serviced.");
    }
}

public class Tk3 {
    public static void main(String[] args) {
        Robot r = new Robot();
        r.powerOn();
        r.operate();
        r.service();
    }
}

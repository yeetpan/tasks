class Vehicle{
    void start(){
        System.out.println("Vehicle is starting");
    }
    void stop(){
        System.out.println("Vehicle is turned Off");
    }
}
 class Bike  extends  Vehicle{
    @Override
    void start(){
        System.out.println("Bike is turned on");
    }
    @Override
    void stop(){
        System.out.println("Bike is turned off");
    }

}

public class Tk2{
    public static void main(String[] args) {
        Vehicle bi=new Bike();
        bi.start();
        bi.stop();
    }
}

public class Calc {
    public void Substraction(int a,int b){
        System.out.println(a+b);
    }
    public void Addition(int a,int b){
        System.out.println(a+b);
    }
    public void Multi(int a,int b){
        System.out.println(a+b);
    }
    public void Division(int a,int b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        Calc o=new Calc();
        o.Addition(2,3);
        o.Substraction(4,3);
        o.Multi(4,4);
        o.Division(16,4);
    }
}

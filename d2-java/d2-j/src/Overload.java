public class Overload {
    public void addn(int a,int b){
        System.out.println(a+b);
    }
    public void addn(String a,String b){
        System.out.println(a+b);
    }

    public static void main(String[] args) {
        Overload o=new Overload();
        o.addn(5,3);
        o.addn("5","3");
    }
}

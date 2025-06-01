import java.util.*;

public class Tk6 {
    public static void main(String[] args) {
        List<String> Names = new ArrayList<>(Arrays.asList("Zubamendi", "Camavinga", "Tchouameni", "Leroy","Sane"));
        Collections.sort(Names);

        for (String name : Names) {
            System.out.println(name);
        }
    }
}

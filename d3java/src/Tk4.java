import java.util.*;

public class Tk4 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("avnish", "navnit", "avnish", "james", "reece");
        Set<String> uniqueNames = new LinkedHashSet<>(names);

        for (String name : uniqueNames) {
            System.out.println(name);
        }
    }
}

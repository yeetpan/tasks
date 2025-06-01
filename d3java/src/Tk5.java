import java.util.*;

public class Tk5 {
    public static void main(String[] args) {
        Map<String, String> countries = new HashMap<>();
        countries.put("IN", "India");
        countries.put("US", "United States");
        countries.put("JP", "Japan");
        countries.put("GB","Great Britian");

        // Iterating using values()
        for (String value : countries.values()) {
            System.out.println(value);
        }
    }
}

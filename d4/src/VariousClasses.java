import java.text.NumberFormat;
import java.util.*;
import java.time.*;
import java.time.temporal.TemporalAdjusters;
import java.util.concurrent.TimeUnit;

// Class representing a person, implements Comparable to allow sorting
class Person implements Comparable<Person> {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // compareTo method to sort by age
    public int compareTo(Person other) {
        return this.age - other.age;
    }

    // toString for displaying Person info
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class VariousClasses {
    public static void main(String[] args) {

        // Numbers and Formatting
        double number = 1234567.89;
        NumberFormat usFormat = NumberFormat.getInstance(Locale.US);
        System.out.println("US Format: " + usFormat.format(number));

        NumberFormat deFormat = NumberFormat.getInstance(Locale.GERMANY);
        System.out.println("German Format: " + deFormat.format(number));

        // Currency Formatting
        double num = 12345.6789;
        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("Formatted Currency (US): " + nf.format(num));

        nf = NumberFormat.getCurrencyInstance(Locale.CHINA);
        System.out.println("Formatted Currency (China): " + nf.format(num));

        // Calendar and Locale
        Calendar cal = Calendar.getInstance(Locale.FRANCE);
        System.out.println("Calendar Time (France): " + cal.getTime());

        // Scanner - user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello, " + name);

        // Parsing and Tokenizing
        String data = "apple,banana,grapes";
        String[] tokens = data.split(",");
        for (String fruit : tokens) {
            System.out.println("Fruit: " + fruit);
        }

        // Generic Collections
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        for (String n : names) {
            System.out.println("Name: " + n);
        }

        // Non-generic collection (can mix types)
        ArrayList mixed = new ArrayList();
        mixed.add("String");
        mixed.add(42);
        for (Object o : mixed) {
            System.out.println("Mixed: " + o);
        }

        // Comparable interface - sorting a list of custom objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Zara", 24));
        people.add(new Person("John", 19));
        Collections.sort(people); // sorts by age using compareTo
        for (Person p : people) {
            System.out.println("Sorted Person: " + p);
        }

        // Math class methods
        System.out.println("PI: " + Math.PI);
        System.out.println("Random: " + Math.random());

        // ClassLoader info
        ClassLoader cl = VariousClasses.class.getClassLoader();
        System.out.println("ClassLoader: " + cl);

        // System class
        System.out.println("Current Time (ms): " + System.currentTimeMillis());

        // Date/Time APIs
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Today: " + today);
        System.out.println("Now: " + now);
        System.out.println("DateTime: " + dateTime);

        // Instant, Duration, Period (for measuring time)
        Instant start = Instant.now();
        try {
            TimeUnit.SECONDS.sleep(2); // simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration.getSeconds() + " seconds");

        Period period = Period.between(LocalDate.of(2000, 1, 1), today);
        System.out.println("Period since 2000: " + period.getYears() + " years");

        // TemporalAdjusters example
        LocalDate nextMonday = today.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println("Next Monday: " + nextMonday);
    }
}

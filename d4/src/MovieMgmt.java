import java.util.*;

// Interface for search functionality
interface Searchable{
    public boolean searchByKeyword(String keyword);
}

// Abstract class implementing Searchable
abstract  class MediaItem implements Searchable{
     protected String title;
     protected String releaseDate;
     protected double rating;
     public MediaItem(String title,String releaseDate,double rating){
         this.title=title;
         this.releaseDate=releaseDate;
         this.rating=rating;
     }
     public String getTitle(){
         return  title;
     }
     public String getReleaseDate(){
         return releaseDate;
     }
     public double getRating(){
         return getRating();
     }
}
// Movie class
 class Movie extends MediaItem{
    private String director;
    private List<String>cast;
    private int duration;
    public Movie(String title,String releaseDate,double rating,String director,List<String>cast,int duration ){
        super(title,releaseDate,rating);
        this.cast=cast;
        this.director=director;
        this.duration=duration;
    }
    public String getDirector(){
        return director;
    }
    public int  getDuration(){
        return duration;
    }


    @Override
    public boolean searchByKeyword(String keyword) {
        //director
        if(director.toLowerCase().contains(keyword)){
            return true;
        }
        //cast
        for(String members:cast){
            if(members.toLowerCase().contains(keyword)){
                return true;
            }
        }
        //title
        if(title.toLowerCase().contains(keyword)){
            return true;
        }

        return false;

    }
}

// Main class
public class MovieMgmt {
    public static void sortByAttribute(List<Movie> movieList, String attribute, String order) {
        Comparator<Movie> comparator = null;
        switch (attribute.toLowerCase()) {
            case "title":
                comparator = Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER);
                break;
            case "director":
                comparator = Comparator.comparing(Movie::getDirector, String.CASE_INSENSITIVE_ORDER);
                break;
            case "releasedate":
                comparator = Comparator.comparing(Movie::getReleaseDate);
                break;
            case "rating":
                comparator = Comparator.comparingDouble(Movie::getRating);
                break;
            case "duration":
                comparator=Comparator.comparingInt(Movie::getDuration);
                break;
        }
        if(comparator!=null){
            if(order.equalsIgnoreCase("desc")){
                comparator.reversed();
            }
            Collections.sort(movieList,comparator);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Movie> movieList = new ArrayList<>();

        int numberOfMovies = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfMovies; i++) {
            String title = scanner.nextLine();
            String releaseDate = scanner.nextLine();
            String director = scanner.nextLine();
            int duration = Integer.parseInt(scanner.nextLine());
            List<String> cast = new ArrayList<>(Arrays.asList(scanner.nextLine().split(",")));
            double rating = Double.parseDouble(scanner.nextLine());
            movieList.add(new Movie(title, releaseDate, rating, director, cast, duration));
        }

        String sortAttribute = scanner.nextLine();
        String sortOrder = scanner.nextLine();
        String searchKeyword = scanner.nextLine();

        // Print search results
        movieList.stream()
                .filter(movie -> movie.searchByKeyword(searchKeyword))
                .forEach(movie -> System.out.println(movie.getTitle()));

        // Sort and print titles
        sortByAttribute(movieList, sortAttribute, sortOrder);
        movieList.forEach(movie -> System.out.println(movie.getTitle()));

        scanner.close();
    }
}

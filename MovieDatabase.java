import java.util.*;

public class MovieDatabase {

    private static HashMap<String, Movie> ourMovies = new HashMap<>();

    public static void initialize(String moviefile) {
        FirstRatings fr = new FirstRatings();
        List<Movie> movies = fr.loadMovies(moviefile);
        for (Movie movie : movies) {
            ourMovies.put(movie.getID(), movie);
        }
    }

    

    public static boolean containsID(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.containsKey(id);
    }

    public static int getYear(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id).getYear();
    }

    public static String getGenres(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id).getGenre();
    }

    public static String getTitle(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id).getTitle();
    }

    public static Movie getMovie(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id);
    }

    public static String getPoster(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id).getPoster();
    }

    public static int getMinutes(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id).getMinutes();
    }

    public static String getCountry(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id).getCountry();
    }

    public static String getDirector(String id) {
        initialize("ratedmoviesfull.csv");
        return ourMovies.get(id).getDirector();
    }

    public static ArrayList<String> filterBy(Filter f) {
        initialize("ratedmoviesfull.csv");
        ArrayList<String> list = new ArrayList<String>();
        for (String id : ourMovies.keySet()) {
            if (f.satisfies(id)) {
                list.add(id);
            }
        }
        return list;
    }

    public static int size() {
        return ourMovies.size();
    }
}
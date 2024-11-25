import java.io.*;
import java.util.*;
import org.apache.commons.csv.*;

public class FirstRatings {

    public ArrayList<Movie> loadMovies(String filename) {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            Reader reader = new BufferedReader(new FileReader(filename));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
            for (CSVRecord record : parser) {
                String id = record.get("id");
                String title = record.get("title");
                int year = Integer.parseInt(record.get("year"));
                String genre = record.get("genre");
                String director = record.get("director");
                String country = record.get("country");
                String poster = record.get("poster");
                int minutes = Integer.parseInt(record.get("minutes"));
                Movie movie = new Movie(id, title, year, genre, director, country, poster, minutes);
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return movies;
    }

    public ArrayList<Rater> loadRaters(String filename) {
        ArrayList<Rater> raters = new ArrayList<>();
        try {
            Reader reader = new BufferedReader(new FileReader(filename));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader());
            Map<String, Rater> raterMap = new HashMap<>();
            for (CSVRecord record : parser) {
                String id = record.get("rater_id");
                String movieID = record.get("movie_id");
                double rating = Double.parseDouble(record.get("rating"));
                if (!raterMap.containsKey(id)) {
                    raterMap.put(id, new PlainRater(id)); // Assuming use of PlainRater
                }
                Rater rater = raterMap.get(id);
                rater.addRating(movieID, rating);
            }
            raters.addAll(raterMap.values());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return raters;
    }
}

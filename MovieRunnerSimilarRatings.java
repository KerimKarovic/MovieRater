import java.util.*;

public class MovieRunnerSimilarRatings {

    public void printSimilarRatings(String raterID, int minimalRaters, int numSimilarRaters) {
        FourthRatings fr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        ArrayList<Rating> ratings = fr.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        for (Rating rating : ratings) {
            System.out.println("Movie: " + MovieDatabase.getTitle(rating.getItem()) + ", Rating: " + rating.getValue());
        }
    }

    public void printSimilarRatingsByGenre(String raterID, String genre, int minimalRaters, int numSimilarRaters) {
        FourthRatings fr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        AllFilters filters = new AllFilters();
        filters.addFilter(new GenreFilter(genre));
        ArrayList<String> filteredMovies = MovieDatabase.filterBy(filters);

        ArrayList<Rating> ratings = fr.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        for (Rating rating : ratings) {
            if (filteredMovies.contains(rating.getItem())) {
                System.out.println("Movie: " + MovieDatabase.getTitle(rating.getItem()) + ", Rating: " + rating.getValue());
            }
        }
    }

    public void printSimilarRatingsByDirector(String raterID, String directors, int minimalRaters, int numSimilarRaters) {
        FourthRatings fr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        AllFilters filters = new AllFilters();
        filters.addFilter(new DirectorsFilter(directors));
        ArrayList<String> filteredMovies = MovieDatabase.filterBy(filters);

        ArrayList<Rating> ratings = fr.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        for (Rating rating : ratings) {
            if (filteredMovies.contains(rating.getItem())) {
                System.out.println("Movie: " + MovieDatabase.getTitle(rating.getItem()) + ", Rating: " + rating.getValue());
            }
        }
    }

    public void printSimilarRatingsByGenreAndMinutes(String raterID, String genre, int minMinutes, int maxMinutes, int minimalRaters, int numSimilarRaters) {
        FourthRatings fr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        AllFilters filters = new AllFilters();
        filters.addFilter(new GenreFilter(genre));
        filters.addFilter(new MinutesFilter(minMinutes, maxMinutes));
        ArrayList<String> filteredMovies = MovieDatabase.filterBy(filters);

        ArrayList<Rating> ratings = fr.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        for (Rating rating : ratings) {
            if (filteredMovies.contains(rating.getItem())) {
                System.out.println("Movie: " + MovieDatabase.getTitle(rating.getItem()) + ", Rating: " + rating.getValue());
            }
        }
    }

    public void printSimilarRatingsByYearAfterAndMinutes(String raterID, int year, int minMinutes, int maxMinutes, int minimalRaters, int numSimilarRaters) {
        FourthRatings fr = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        AllFilters filters = new AllFilters();
        filters.addFilter(new YearAfterFilter(year));
        filters.addFilter(new MinutesFilter(minMinutes, maxMinutes));
        ArrayList<String> filteredMovies = MovieDatabase.filterBy(filters);

        ArrayList<Rating> ratings = fr.getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        for (Rating rating : ratings) {
            if (filteredMovies.contains(rating.getItem())) {
                System.out.println("Movie: " + MovieDatabase.getTitle(rating.getItem()) + ", Rating: " + rating.getValue());
            }
        }
    }
}
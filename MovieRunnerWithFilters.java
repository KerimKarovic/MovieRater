import java.util.*;

public class MovieRunnerWithFilters {

    public void printAverageRatings() {
        ThirdRatings tr = new ThirdRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratings.csv");
        MovieDatabase.initialize("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratedmoviesfull.csv");

        int minimalRaters = 35;
        ArrayList<Rating> avgRatings = tr.getAverageRatings(minimalRaters);
        Collections.sort(avgRatings); // Optional: Sort ratings if you want to see them in order
        System.out.println("Number of rated movies: " + avgRatings.size());
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfter() {
        ThirdRatings tr = new ThirdRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratings.csv");
        MovieDatabase.initialize("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratedmoviesfull.csv");

        int minimalRaters = 20;
        int year = 2000;
        Filter filterCriteria = new YearAfterFilter(year);
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        Collections.sort(avgRatings); // Optional
        System.out.println("Number of rated movies after year " + year + ": " + avgRatings.size());
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByGenre() {
        ThirdRatings tr = new ThirdRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratings.csv");
        MovieDatabase.initialize("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratedmoviesfull.csv");

        int minimalRaters = 20;
        String genre = "Comedy";
        Filter filterCriteria = new GenreFilter(genre);
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        Collections.sort(avgRatings); // Optional
        System.out.println("Number of rated movies in genre " + genre + ": " + avgRatings.size());
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByMinutes() {
        ThirdRatings tr = new ThirdRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratings.csv");
        MovieDatabase.initialize("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratedmoviesfull.csv");

        int minimalRaters = 5;
        int minMinutes = 105;
        int maxMinutes = 135;
        Filter filterCriteria = new MinutesFilter(minMinutes, maxMinutes);
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        Collections.sort(avgRatings); // Optional
        System.out.println("Number of rated movies with duration between " + minMinutes + " and " + maxMinutes + " minutes: " + avgRatings.size());
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectors() {
        ThirdRatings tr = new ThirdRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratings.csv");
        MovieDatabase.initialize("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratedmoviesfull.csv");

        int minimalRaters = 4;
        String directors = "Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack";
        Filter filterCriteria = new DirectorsFilter(directors);
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minimalRaters, filterCriteria);
        Collections.sort(avgRatings); // Optional
        System.out.println("Number of rated movies by specified directors: " + avgRatings.size());
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByYearAfterAndGenre() {
        ThirdRatings tr = new ThirdRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratings.csv");
        MovieDatabase.initialize("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratedmoviesfull.csv");

        int minimalRaters = 8;
        int year = 1990;
        String genre = "Drama";
        AllFilters filters = new AllFilters();
        filters.addFilter(new YearAfterFilter(year));
        filters.addFilter(new GenreFilter(genre));
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minimalRaters, filters);
        Collections.sort(avgRatings); // Optional
        System.out.println("Number of rated movies after year " + year + " in genre " + genre + ": " + avgRatings.size());
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public void printAverageRatingsByDirectorsAndMinutes() {
        ThirdRatings tr = new ThirdRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratings.csv");
        MovieDatabase.initialize("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\ratedmoviesfull.csv");

        int minimalRaters = 3;
        int minMinutes = 90;
        int maxMinutes = 180;
        String directors = "Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack";
        AllFilters filters = new AllFilters();
        filters.addFilter(new MinutesFilter(minMinutes, maxMinutes));
        filters.addFilter(new DirectorsFilter(directors));
        ArrayList<Rating> avgRatings = tr.getAverageRatingsByFilter(minimalRaters, filters);
        Collections.sort(avgRatings); // Optional
        System.out.println("Number of rated movies with specified directors and duration between " + minMinutes + " and " + maxMinutes + " minutes: " + avgRatings.size());
        for (Rating rating : avgRatings) {
            System.out.println(rating.getValue() + " " + MovieDatabase.getTitle(rating.getItem()));
        }
    }

    public static void main(String[] args) {
        MovieRunnerWithFilters runner = new MovieRunnerWithFilters();
        System.out.println("---------------printAverageRatings test----------------");
        runner.printAverageRatings();
        System.out.println("---------------printAverageRatingsByYearAfter test----------------");
        runner.printAverageRatingsByYearAfter();
        System.out.println("---------------printAverageRatingsByGenre test----------------");
        runner.printAverageRatingsByGenre();
        System.out.println("---------------printAverageRatingsByMinutes test----------------");
        runner.printAverageRatingsByMinutes();
        System.out.println("---------------printAverageRatingsByDirectors test----------------");
        runner.printAverageRatingsByDirectors();
        System.out.println("---------------printAverageRatingsByYearAfterAndGenre test----------------");
        runner.printAverageRatingsByYearAfterAndGenre();
        System.out.println("---------------printAverageRatingsByDirectorsAndMinutes test----------------");
        runner.printAverageRatingsByDirectorsAndMinutes();
    }
}

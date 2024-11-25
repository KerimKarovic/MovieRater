import java.util.*;

public class Recommendation implements recommender {

    public ArrayList<String> getItemsToRate() {
        ArrayList<String> itemsToRate = new ArrayList<>();
        ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());

        Random rand = new Random();
        while (itemsToRate.size() < 20) {
            int randomIndex = rand.nextInt(movies.size());
            String movieID = movies.get(randomIndex);
            if (!itemsToRate.contains(movieID)) {
                itemsToRate.add(movieID);
            }
        }

        return itemsToRate;
    }

    public void printRecommendationsFor(String webRaterID) {
        FourthRatings fourthRatings = new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull.csv");
        RaterDatabase.initialize("ratings.csv");

        System.out.println("Answer for question 1: Read data for " + RaterDatabase.size() + " raters");
        System.out.println("Answer for question 2: Read data for " + MovieDatabase.size() + " movies");

        int numSimilarRaters = 50;
        int minNumOfRatings = 5;
        ArrayList<Rating> similarRatings = fourthRatings.getSimilarRatings(webRaterID, numSimilarRaters, minNumOfRatings);

        if (similarRatings.size() == 0) {
            System.out.println("Answer for question 3: No matching movies were found");
        } else {
            String header = "<table> <tr> <th>Movie Title</th> <th>Rating Value</th> <th>Genres</th> </tr>";
            StringBuilder body = new StringBuilder();
            for (Rating rating : similarRatings) {
                body.append("<tr> <td>").append(MovieDatabase.getTitle(rating.getItem()))
                    .append("</td> <td>").append(rating.getValue())
                    .append("</td> <td>").append(MovieDatabase.getGenres(rating.getItem()))
                    .append("</td> </tr>");
            }
            System.out.println(header + body.toString() + "</table>");
        }
    }
}

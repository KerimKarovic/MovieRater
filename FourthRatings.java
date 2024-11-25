import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FourthRatings {

    private static HashMap<String, Rater> ourRaters;

    public static void loadRaters(String filename) {
        ourRaters = new HashMap<String, Rater>();
        RaterDatabase.addRatings(filename);
    }

    // Method to calculate dot product of two raters
    public double dotProduct(Rater rater1, Rater rater2) {
        double dotProduct = 0.0;
        for (String movieID : rater1.getItemsRated()) {
            if (rater2.hasRating(movieID)) {
                dotProduct += (rater1.getRating(movieID) - 5) * (rater2.getRating(movieID) - 5);
            }
        }
        return dotProduct;
    }

    // Method to get similar ratings
    public ArrayList<Rating> getSimilarRatings(String raterID, int numSimilarRaters, int minimalRaters) {
        ArrayList<Rating> similarRatings = new ArrayList<>();
        Rater rater = RaterDatabase.getRater(raterID);
        ArrayList<Rater> raters = RaterDatabase.getRaters();

        for (Rater otherRater : raters) {
            if (!otherRater.getID().equals(raterID)) {
                double similarity = dotProduct(rater, otherRater);
                if (similarity > 0) {
                    similarRatings.add(new Rating(otherRater.getID(), similarity));
                }
            }
        }

        // Sort by similarity in descending order
        similarRatings.sort((r1, r2) -> Double.compare(r2.getValue(), r1.getValue()));
        return similarRatings;
    }

    // Method to get similar ratings by filter
    public ArrayList<Rating> getSimilarRatingsByFilter(String raterID, Filter filter, int numSimilarRaters, int minimalRaters) {
        ArrayList<Rating> similarRatings = getSimilarRatings(raterID, numSimilarRaters, minimalRaters);
        ArrayList<Rating> filteredRatings = new ArrayList<>();

        for (Rating rating : similarRatings) {
            if (filter.satisfies(rating.getItem())) {
                filteredRatings.add(rating);
            }
        }

        return filteredRatings;
    }

    // Method to get weighted average rating for a movie
    public double getAverageByID(String id, int minimalRaters) {
        ArrayList<Rater> raters = RaterDatabase.getRaters();
        double weightedSum = 0;
        int totalRaters = 0;

        for (Rater rater : raters) {
            if (rater.hasRating(id)) {
                weightedSum += rater.getRating(id);
                totalRaters++;
            }
        }

        return totalRaters >= minimalRaters ? weightedSum / totalRaters : 0.0;
    }
}
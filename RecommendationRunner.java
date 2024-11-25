import java.util.*;

public class RecommendationRunner implements Recommender {

    @Override
    public ArrayList<String> getItemsToRate() {
        ArrayList<String> movieList = new ArrayList<>();
        ArrayList<String> allMovies = MovieDatabase.filterBy(new TrueFilter());

        // Randomly select 10 movies from the database
        Random rand = new Random();
        HashSet<String> selectedMovies = new HashSet<>();

        while (selectedMovies.size() < 10) {
            int randomIndex = rand.nextInt(allMovies.size());
            String movieID = allMovies.get(randomIndex);
            selectedMovies.add(movieID);
        }

        movieList.addAll(selectedMovies);
        return movieList;
    }

    @Override
    public void printRecommendationsFor(String webRaterID) {
        FourthRatings fr = new FourthRatings();
        int minimalRaters = 5;  // You can adjust this value as needed
        int numTopMovies = 10;  // Number of top recommendations to show

        ArrayList<Rating> recommendations = fr.getSimilarRatings(webRaterID, 20, minimalRaters);
        if (recommendations.isEmpty()) {
            System.out.println("<h2>No movie recommendations based on your ratings.</h2>");
            return;
        }

        System.out.println("<style>");
        System.out.println("table {");
        System.out.println("  font-family: Arial, sans-serif;");
        System.out.println("  border-collapse: collapse;");
        System.out.println("  width: 100%;");
        System.out.println("}");
        System.out.println("td, th {");
        System.out.println("  border: 1px solid #dddddd;");
        System.out.println("  text-align: left;");
        System.out.println("  padding: 8px;");
        System.out.println("}");
        System.out.println("tr:nth-child(even) {");
        System.out.println("  background-color: #f2f2f2;");
        System.out.println("}");
        System.out.println("</style>");

        System.out.println("<h2>Movie Recommendations for You</h2>");
        System.out.println("<table>");
        System.out.println("<tr><th>Rank</th><th>Movie Title</th><th>Year</th><th>Genres</th></tr>");

        int count = 0;
        for (Rating rating : recommendations) {
            if (count >= numTopMovies) break;
            String movieID = rating.getItem();
            String title = MovieDatabase.getTitle(movieID);
            int year = MovieDatabase.getYear(movieID);
            String genres = MovieDatabase.getGenres(movieID);

            System.out.println("<tr>");
            System.out.println("<td>" + (count + 1) + "</td>");
            System.out.println("<td>" + title + "</td>");
            System.out.println("<td>" + year + "</td>");
            System.out.println("<td>" + genres + "</td>");
            System.out.println("</tr>");

            count++;
        }

        System.out.println("</table>");
    }
}

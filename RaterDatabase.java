import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;
import java.util.HashMap;

public class RaterDatabase {
    private static HashMap<String, Rater> ourRaters;

    private static void initialize() {
        if (ourRaters == null) {
            ourRaters = new HashMap<String, Rater>();
        }
    }

    public static void initialize(String filename) {
        if (ourRaters == null) {
            ourRaters = new HashMap<String, Rater>();
            addRatings("C:\\Users\\kerim\\Desktop\\Java Projects\\StepOne\\" + filename); // Update file path here
        }
    }

    public static void addRatings(String filename) {
        initialize();
        FileResource fr = new FileResource(filename);
        CSVParser csvp = fr.getCSVParser();
        for (CSVRecord rec : csvp) {
            String id = rec.get("rater_id");
            String item = rec.get("movie_id");
            String rating = rec.get("rating");
            addRaterRating(id, item, Double.parseDouble(rating));
        }
    }

    public static void addRaterRating(String raterID, String movieID, double rating) {
        initialize();
        Rater rater = null;
        if (ourRaters.containsKey(raterID)) {
            rater = ourRaters.get(raterID);
        } else {
            rater = new EfficientRater(raterID);
            ourRaters.put(raterID, rater);
        }
        rater.addRating(movieID, rating);
    }

    public static Rater getRater(String id) {
        initialize();
        return ourRaters.get(id);
    }

    public static ArrayList<Rater> getRaters() {
        initialize();
        ArrayList<Rater> list = new ArrayList<Rater>(ourRaters.values());
        return list;
    }

    public static int size() {
        return ourRaters.size();
    }
}
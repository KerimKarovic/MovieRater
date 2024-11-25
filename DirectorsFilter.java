import java.util.*;

public class DirectorsFilter implements Filter {
    private List<String> directors;

    public DirectorsFilter(String directors) {
        this.directors = Arrays.asList(directors.split(","));
    }

    @Override
    public boolean satisfies(String id) {
        String movieDirectors = MovieDatabase.getDirector(id);
        for (String director : directors) {
            if (movieDirectors.contains(director)) {
                return true;
            }
        }
        return false;
    }
}
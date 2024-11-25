public class Movie {
    private String id;
    private String title;
    private int year;
    private String genre;
    private String director;
    private String country;
    private String poster;
    private int minutes;

    public Movie(String id, String title, int year, String genre, String director, String country, String poster, int minutes) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.director = director;
        this.country = country;
        this.poster = poster;
        this.minutes = minutes;
    }

    // Getters
    public String getID() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getCountry() {
        return country;
    }

    public String getPoster() {
        return poster;
    }

    public int getMinutes() {
        return minutes;
    }

    @Override
    public String toString() {
        return String.format("Movie[id=%s, title=%s, year=%d, genre=%s, director=%s, country=%s, poster=%s, minutes=%d]",
                             id, title, year, genre, director, country, poster, minutes);
    }
}

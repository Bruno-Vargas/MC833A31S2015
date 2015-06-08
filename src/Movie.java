/**
 * Created by BrunoVargas on 07/06/15.
 */

public class Movie
implements java.io.Serializable
{
    private String title;
    private String genre;
    private String director;
    private String synopsis;
    private int year;
    private float duration;
    private int identifier;
    private int quantity;
/*
* Constructor
* */
    public Movie(String title, String genre, String director,
                String synopsis, int year, float duration, int identifier, int quantity) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.synopsis = synopsis;
        this.year = year;
        this.duration = duration;
        this.identifier = identifier;
        this.quantity = quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getSynopsis() {
        return synopsis + "\n";
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getDuration() {
        return duration;
    }

    public void setIdentifier(int identifier) {
    this.identifier = identifier;
}

    public int getIdentifier() {
        return identifier;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getAllInfo() {
        return  title + "\n" + genre + "\n" + director + "\n" + synopsis + "\n" +
                year + "\n" + duration + "\n" + identifier  + "\n" + quantity + "\n";
    }

    public String getTitleAndYear(){
        return title + year + "\n";
    }
}

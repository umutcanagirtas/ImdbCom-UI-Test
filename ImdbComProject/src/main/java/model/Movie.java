package model;

import java.util.List;
import java.util.Objects;

public class Movie {
    private String director;
    private List<String> writers;
    private String stars;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return director.equals(movie.director) && writers.equals(movie.writers) && stars.equals(movie.stars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, writers, stars);
    }


    public void setMovie(String director,String stars,List<String> writers){
        setWriters(writers);
        setStars(stars);
        setDirector(director);
    }

}

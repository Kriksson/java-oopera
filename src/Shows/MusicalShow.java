package Shows;

import Persons.Actor;
import Persons.Director;
import Persons.Person;

import java.util.List;

public class MusicalShow extends Show {
    private final Person musicAuthor;
    private final String librettoText;

    public MusicalShow(String title, int duration, Director director,
                       List<Actor> actors, Person musicAuthor, String librettoText) {
        super(title, duration, director, actors);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }

    public void printLibretto() {
        System.out.println("Либретто: " + librettoText);
    }

    public Person getMusicAuthor() {
        return musicAuthor;
    }
}

package Shows;

import Persons.Actor;
import Persons.Director;
import Persons.Person;

import java.util.List;

public class Ballet extends MusicalShow {

    private final Person choreographer;

    public Ballet(String title, int duration, Director director,
                  List<Actor> actors, Person musicAuthor, String librettoText, Person choreographer) {
        super(title, duration, director, actors, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public Person getChoreographer() {
        return choreographer;
    }
}

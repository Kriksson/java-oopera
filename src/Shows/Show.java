package Shows;

import Persons.Actor;
import Persons.Director;

import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String title;
    private final int duration;
    private final Director director;
    private final List<Actor> actors;

    public Show(String title, int duration, Director director, List<Actor> actors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.actors = new ArrayList<>(actors);
    }

    public void printDirectorName() {
        System.out.println(director.toString());
    }

    public void printActors() {
        StringBuilder result = new StringBuilder();
        result.append("Актёры: ");
        for (int i = 0; i < actors.size(); i++) {
            Actor actor = actors.get(i);
            if (i == actors.size() - 1) {
                result.append(actor.getName()).append(" ")
                        .append(actor.getSurname()).append("(").append(actor.getHeight()).append(").");
            } else {
                result.append(actor.getName()).append(" ")
                        .append(actor.getSurname()).append("(").append(actor.getHeight()).append("), ");
            }
        }
        System.out.println(result);
    }

    public void addActor(Actor actor) {
        for (Actor existActor : actors) {
            if (existActor.getName().equals(actor.getName())
            &&  existActor.getSurname().equals(actor.getSurname())
            &&  existActor.getHeight() == actor.getHeight()) {
                System.out.println("Такой актёр уже добавлен");
                return;
            }
        }
        actors.add(actor);
    }

    public void changeActor(Actor actor, String surnameReplacedActor) {
        int index = -1;
        int matchCount = 0;

        for (int i = 0; i < actors.size(); i++) {
            if (actors.get(i).getSurname().equals(surnameReplacedActor)) {
                index = i;
                matchCount++;
            }
        }

        if (matchCount == 0) {
            System.out.println("Актёр не найден!");
        } else if (matchCount > 1) {
            System.out.println("Найдены однофамильцы, замена невозможна.");
        } else {
            actors.set(index, actor);
        }
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
import Persons.Actor;
import Persons.Director;
import Persons.Gender;
import Persons.Person;
import Shows.Balet;
import Shows.Opera;
import Shows.Show;

import java.util.ArrayList;

public class Theatre {

    public static void main(String[] args) {
        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 180);
        Actor actor2 = new Actor("Анна", "Петрова", Gender.FEMALE, 168);
        Actor actor3 = new Actor("Дмитрий", "Сидоров", Gender.MALE, 175);

        Director director1 = new Director("Алексей", "Орлов", Gender.MALE, 12);
        Director director2 = new Director("Мария", "Волкова", Gender.FEMALE, 8);

        Person musicAuthor = new Person("Пётр", "Соколов", Gender.MALE);
        Person choreographer = new Person("Елена", "Морозова", Gender.FEMALE);

        Show show = new Show("Городские истории",
                120,
                director1,
                new ArrayList<>()
        );

        System.out.println("Обычный спектакль:");
        System.out.println("Название: " + show.getTitle());
        System.out.println("Длительность: " + show.getDuration() + " мин.");
        show.printDirectorName();
        System.out.println("Количество постановок режиссёра: " + director1.getNumberOfShows());

        Opera opera = new Opera("Тайна старого замка",
                150,
                director2,
                new ArrayList<>(),
                musicAuthor,
                "Первое действие начинается в старом замке...",
                20
        );

        System.out.println("\nОпера:");
        System.out.println("Название: " + opera.getTitle());
        System.out.println("Длительность: " + opera.getDuration() + " мин.");
        opera.printDirectorName();
        Person operaMusicAuthor = opera.getMusicAuthor();
        System.out.println("Автор музыки: " + operaMusicAuthor.getName() + " " + operaMusicAuthor.getSurname());
        System.out.println("Количество человек в хоре: " + opera.getChoirSize());

        Balet balet = new Balet("Лебединое озеро",
                110,
                director1,
                new ArrayList<>(),
                musicAuthor,
                "В парке перед замком владетельной принцессы веселится молодежь...",
                choreographer
        );

        System.out.println("\nБалет:");
        System.out.println("Название: " + balet.getTitle());
        System.out.println("Длительность: " + balet.getDuration() + " мин.");
        balet.printDirectorName();

        Person balletMusicAuthor = balet.getMusicAuthor();
        System.out.println("Автор музыки: " + balletMusicAuthor.getName() + " " + balletMusicAuthor.getSurname());
        Person balletChoreographer = balet.getChoreographer();
        System.out.println("Хореограф: " + balletChoreographer.getName() + " " + balletChoreographer.getSurname());

        show.addActor(actor1);
        show.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        balet.addActor(actor1);
        balet.addActor(actor3);

        System.out.println("Спектакль «Городские истории»:");
        show.printActors();

        System.out.println("\nОпера «Тайна старого замка»:");
        opera.printActors();

        System.out.println("\nБалет «Лунное озеро»:");
        balet.printActors();

        System.out.println("\nСостав спектакля после замены:");
        show.changeActor(actor3, "Иванов");
        show.printActors();

        System.out.println("\nПопытка заменить отсутствующего актёра:");
        opera.changeActor(actor1, "Несуществующий");

        System.out.println("\nЛибретто оперы:");
        opera.printLibretto();

        System.out.println("\nЛибретто балета:");
        balet.printLibretto();

        System.out.println("\nПытаемся добавить уже добавленного актёра:");
        balet.addActor(actor1);
    }
}

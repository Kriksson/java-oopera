import Persons.Actor;
import Persons.Director;
import Persons.Gender;
import Persons.Person;
import Shows.Ballet;
import Shows.Opera;
import Shows.Show;

import java.util.ArrayList;

public class Theatre {

    public static void main(String[] args) {
        Actor actor1 = new Actor("Иван", "Иванов", Gender.MALE, 180);
        Actor actor2 = new Actor("Анна", "Петрова", Gender.FEMALE, 168);
        Actor actor3 = new Actor("Дмитрий", "Сидоров", Gender.MALE, 175);
        Actor actor4 = new Actor("Иван", "Сидоров", Gender.MALE, 176);

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
        System.out.println("Автор музыки: " + operaMusicAuthor.toString());
        System.out.println("Количество человек в хоре: " + opera.getChoirSize());

        Ballet ballet = new Ballet("Лебединое озеро",
                110,
                director1,
                new ArrayList<>(),
                musicAuthor,
                "В парке перед замком владетельной принцессы веселится молодежь...",
                choreographer
        );

        System.out.println("\nБалет:");
        System.out.println("Название: " + ballet.getTitle());
        System.out.println("Длительность: " + ballet.getDuration() + " мин.");
        ballet.printDirectorName();

        Person balletMusicAuthor = ballet.getMusicAuthor();
        System.out.println("Автор музыки: " + balletMusicAuthor.toString());
        Person balletChoreographer = ballet.getChoreographer();
        System.out.println("Хореограф: " + balletChoreographer.toString());

        show.addActor(actor1);
        show.addActor(actor2);

        opera.addActor(actor2);
        opera.addActor(actor3);

        ballet.addActor(actor1);
        ballet.addActor(actor3);

        System.out.println("Спектакль «" + show.getTitle() + "»:");
        show.printActors();

        System.out.println("\nОпера «" + opera.getTitle() + "»:");
        opera.printActors();

        System.out.println("\nБалет «" + ballet.getTitle() + "»:");
        ballet.printActors();

        System.out.println("\nСостав спектакля после замены:");
        show.changeActor(actor3, "Иванов");
        show.printActors();

        show.addActor(actor4);
        System.out.println("\nПопытка заменить актёра при наличии однофамильцев:");
        show.changeActor(actor3, "Сидоров");
        show.printActors();

        System.out.println("\nПопытка заменить отсутствующего актёра:");
        opera.changeActor(actor1, "Несуществующий");

        System.out.println("\nЛибретто оперы:");
        opera.printLibretto();

        System.out.println("\nЛибретто балета:");
        ballet.printLibretto();

        System.out.println("\nПытаемся добавить уже добавленного актёра:");
        ballet.addActor(actor1);
    }
}

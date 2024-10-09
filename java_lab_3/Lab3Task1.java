import java.util.Arrays;

public class Lab3Task1 {
    public static void main(String[] args) {
        Show show1 = new Show("Автор 1", "Передача 1", "Описание 1");
        Show show2 = new Show("Автор 2", "Передача 2", "Описание 2");
        Show show3 = new Show("Автор 3", "Передача 3", "Описание 3");

        GroupTeleprogram group = new GroupTeleprogram(new Show[]{show1, show2, show3});

        Show show4 = new Show("Автор 4", "Передача 4", "Описание 4");
        group.addShow(show4);

        group.removeShow("Передача 2");

        group.sortShowsByName();

        System.out.println(group);
    }
}

class GroupTeleprogram {
    private static int counter = 0;
    private final int uniqueNumber;
    private Show[] shows;

    public GroupTeleprogram() {
        this.uniqueNumber = counter++;
        this.shows = new Show[0];
    }

    public GroupTeleprogram(Show[] shows) {
        this.uniqueNumber = counter++;
        this.shows = shows;
    }

    public void setShows(Show[] shows) {
        this.shows = shows;
    }

    public Show[] getShows() {
        return this.shows;
    }

    public void setShow(Show show, int indexShow) {
        if (indexShow >= 0 && indexShow < shows.length) {
            this.shows[indexShow] = show;
            return;
        }
        System.out.printf("Индекс шоу должен быть больше или равен 0 и меньше длины массива шоу: %d%n", shows.length);
    }

    public Show getShow(int indexShow) {
        if (indexShow >= 0 && indexShow < shows.length) {
            return this.shows[indexShow];
        }
        System.out.printf("Индекс шоу должен быть больше или равен 0 и меньше длины массива шоу: %d%n", shows.length);
        return null;
    }

    public void addShow(Show show){
        shows = Arrays.copyOf(shows, shows.length + 1);
        shows[shows.length - 1] = show;
    }

    public void removeShow(String name){
        shows = Arrays.stream(shows)
                .filter(show -> !show.getName().equals(name))
                .toArray(Show[]::new);
    }

    public void sortShowsByName(){
        Arrays.sort(shows, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("Group ID: " + uniqueNumber + "\nТелепрограммы:\n");
        for (Show show : shows) {
            sb.append(show).append("\n");
        }
        return sb.toString();
    }
}

class Show {
    private String author;
    private String name;
    private String description;
    private int periodType;

    public Show(String author, String name, String description) {
        this.author = author;
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getPeriodType() {
        return switch (periodType) {
            case 1 -> "Ежедневно";
            case 2 -> "Еженедельно";
            case 3 -> "Ежемесячно";
            default -> "Не указано или индекс типа периода шоу не входит в диапазон [1, 3]";
        };
    }

    public void setPeriodType(int periodType) {
        if (periodType >= 1 && periodType <= 3) {
            this.periodType = periodType;
            return;
        }
        throw new IllegalArgumentException("Индекс типа периода шоу не входит в диапазон [1, 3]");
    }

    @Override
    public String toString() {
        return String.format("Автор: %s, Название: %s, Описание: %s, Периодичность: %s",
                author, name, description, getPeriodType());
    }
}
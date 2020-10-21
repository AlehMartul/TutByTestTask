package data;

public enum Genres {
    COMEDY("Комедия"),
    ACTION("Боевик"),
    DETECTIVE("Детектив"),
    FANTASY("Фэнтези"),
    FICTION("Фантастика"),
    ANIME("Аниме"),
    HORROR("Ужасы"),
    THRILLER("Триллер"),
    DRAMA("Драма"),
    MELODRAMA("Мелодрама");

    private String title;

    Genres(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

}
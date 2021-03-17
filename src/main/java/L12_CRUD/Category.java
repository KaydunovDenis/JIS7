package L12_CRUD;

public enum Category {
    PHONE ("Телефон"),
    TABLET("Планшет"),
    NOTEBOOK("Ноутбук"),
    COMPUTER("Компьютер");

    private String title;

    Category(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "title='" + title + '\'' +
                '}';
    }
}

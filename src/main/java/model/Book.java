package model;

public class Book extends Position {
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" + "name=" + getName() +
                ", minAge=" + getMinAge() +
                ", author='" + author + '\'' +
                '}';
    }
}

package model;

import java.util.ArrayList;

public class Movie extends Position {
    private ArrayList<String> cast;

    public void setCast(ArrayList<String> cast) {
        this.cast = cast;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name=" + getName() +
                ", minAge=" + getMinAge() +
                ", cast=" + cast +
                '}';
    }
}

package model;

public class Game extends Position {
    private int maxAge;

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name=" + getName() +
                ", minAge=" + getMinAge() +
                ", maxAge=" + maxAge +
                '}';
    }
}

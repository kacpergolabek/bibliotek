import model.Book;
import model.Game;
import model.Movie;
import model.Position;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final ArrayList<Position> positions = new ArrayList<>();

    private static void addNewPosition() {
        System.out.println("Which position do you want to add?(1 - Book, 2 - Game, 3 - Movie):");

        Scanner in = new Scanner(System.in);
        int option = in.nextInt();

        if (option == 1) {
            Book book = new Book();
            System.out.print("Name: ");
            book.setName(in.next());

            System.out.print("Author: ");
            book.setAuthor(in.next());

            System.out.print("Minimal age: ");
            book.setMinAge(in.nextInt());

            positions.add(book);
        }
        else if (option == 2) {
            Game game = new Game();

            System.out.print("Name: ");
            game.setName(in.next());

            System.out.print("Min age: ");
            game.setMinAge(in.nextInt());

            System.out.print("Max age: ");
            game.setMaxAge(in.nextInt());

            positions.add(game);
        }
        else if (option == 3) {
            Movie movie = new Movie();
            System.out.print("Name: ");
            movie.setName(in.next());

            System.out.print("Minimal age: ");
            movie.setMinAge(in.nextInt());

            System.out.print("Actors('/' - delimeter): ");
            String text = in.next();

            ArrayList<String> actors = new ArrayList<>(Arrays.asList(text.split("/")));

            movie.setCast(actors);

            positions.add(movie);
        }

    }

    private static void displayPositions() {
        int counter = 1;

        System.out.println("List of positions: ");

        for (Position position : positions){
            System.out.println(counter + ". " + position);
            counter++;
        }


    }

    private static void generateRaport() {
        System.out.println("Raport:");

        System.out.println("Number of books: " + positions.stream().filter(position -> position instanceof Book).count());
        System.out.println("Number of games: " + positions.stream().filter(position -> position instanceof Game).count());
        System.out.println("Number of movies: " + positions.stream().filter(position -> position instanceof Movie).count());
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);

        while (true){
            System.out.println("Choose option(1 - add new  position, 2 - display list, 3 - generate raport, 4 - save to file, 5 - end program):");
            int option = in.nextInt();

            switch (option){
                case 1:
                    addNewPosition();
                    break;
                case 2:
                    displayPositions();
                    break;
                case 3:
                    generateRaport();
                    break;
                case 4:
                    saveToFile();
                    break;
                case 5:
                    return;
            }
        }



    }

    private static void saveToFile() throws FileNotFoundException {
        PrintWriter save = new PrintWriter("test.txt");

        int counter = 1;

        for (Position position: positions){
            save.println(counter + ". " + position);
            counter++;
        }

        save.close();

        System.out.println("Save to file successfully!");
    }


}

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static final String MOVIES_FILE = "GuessTheMovie.txt";
    private static final int MAXIMUM_ERRORS = 10;

    public static void main(String[] args) throws FileNotFoundException {
        MoviePicker moviePicker = new MoviePicker(MOVIES_FILE);
        String movie = moviePicker.pick();

        Game game = new Game(movie);

        while (game.getNumErrors() < MAXIMUM_ERRORS) {
            if (game.currentAnswer().equals(movie)) {
                System.out.println("YOU WIN!\n");
                System.out.printf("You have guessed \"%s\" correctly.\n", movie);
                break;
            }

            System.out.printf("You are guessing: %s\n", game.currentAnswerWithSpaces());
            System.out.printf("You have guessed %s wrong letters;\n", game.getNumErrors());
            System.out.println("Guess a letter: ");

            Scanner scanner = new Scanner(System.in);
            String letter = scanner.nextLine().toLowerCase();

            game.mark(game.answerHas(letter));
        }

        if (game.getNumErrors() >= MAXIMUM_ERRORS) {
            System.out.println("GAME OVER!");
        }
    }
}

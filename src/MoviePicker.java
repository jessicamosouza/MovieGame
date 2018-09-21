import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class MoviePicker {

    //fields
    private ArrayList<String> moviesList = new ArrayList<>();

    //constructor
    MoviePicker(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            moviesList.add(scanner.nextLine());
        }
    }

    String pick() {
        // returns a random list element
        int randomNumber = (int) ((Math.random() * moviesList.size()) - 1);
        return moviesList.get(randomNumber);
    }
}

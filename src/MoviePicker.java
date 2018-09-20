import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class MoviePicker {

    //fields
    private ArrayList<String> moviesList = new ArrayList<>();

    //constructor
    MoviePicker(String fileName) throws FileNotFoundException {
        // parsear arquivo com caminho fileName
        // adicionar linha a linha do arquivo no
        // array this.movies

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            moviesList.add(scanner.nextLine());
        }
    }

    String pick() {
        // retorna uma posição randomica do array
        // this.movies
        int randomNumber = (int) ((Math.random() * moviesList.size()) - 1);
//        System.out.println("\nRandom Number: "+ randomNumber);

        return moviesList.get(randomNumber);
    }
}

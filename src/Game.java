import java.util.ArrayList;

class Game {

    private int numErrors = 0;
    private String finalAnswer;
    private ArrayList<String> currentUserAnswer;

    Game(String movie) {
        finalAnswer = movie;

        currentUserAnswer = new ArrayList<>();
        for (int i = 0; i < finalAnswer.length(); i++) {
            if (finalAnswer.charAt(i) == ' ') {
                currentUserAnswer.add(" ");
                continue;
            }
            currentUserAnswer.add("_");
        }
    }

    String currentAnswer() {
        return String.join("", currentUserAnswer);
    }

    int getNumErrors() {
        // if has not a letter
        //loose a point (max 10)
        return numErrors;
    }

    ArrayList<Integer> answerHas(String letter) {
        ArrayList<Integer> occurrences = new ArrayList<>();

        int index = finalAnswer.indexOf(letter);
        if (index != -1) {
            occurrences.add(index);
        } else {
            numErrors += 1;
        }

        while (index != -1) {
            index = finalAnswer.indexOf(letter, index + 1);
            if (index != -1) {
                occurrences.add(index);
            }
        }

        return occurrences;
    }

    String currentAnswerWithSpaces() {
        StringBuilder dashedMovieName = new StringBuilder();
        for (String letter : currentUserAnswer) {
            dashedMovieName.append(letter).append(" ");
        }
        return dashedMovieName.toString();
    }

    void mark(ArrayList positions) {
        for (int i = 0; i < currentUserAnswer.size(); i++) {
            for (Object position : positions) {
                // if position match
                // and position is to be filled within currentUserAnswer
                if (i == (Integer) position) { // || currentUserAnswer.get(j).equals("_")
                    currentUserAnswer.set(i, "" + finalAnswer.charAt(i));
                }
            }
        }
    }
}

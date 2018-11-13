package com.themovieguessing;

public class Game {

    private static boolean gameOverState; //check if the player won after finishing game
    private static String gameOverMovie; //movieTitle after finishing the game
    private String movieTitle = ""; //movieTitle from movies file
    private String movieEncrypted = ""; //movieTitle After being changed to (*)
    private StringBuilder movieTitleAsterisks; //movieTitle that will change during the gameplay
    private boolean isEntered[]; //check if a letter was entered
    private boolean isCorrect; //check if the letter was correct
    private int spaces; //Counts the spaces in the movieTitle
    private int movieLength; //movieTitle length without spaces
    private int score; //Guesses left before losing

    //the game initialization after creating object from the class *NOT CONSTRUCTOR*
    void startGame() {
        spaces = 0;
        score = 10;
        isEntered = new boolean[movieTitle.length()];
        isCorrect = false;
        movieEncrypted = movieAsterisks();
        movieLength = movieTitle.length() - spaces;
        movieTitleAsterisks = new StringBuilder(movieEncrypted);
        gameOverState = false;
        gameOverMovie = movieTitle;
    }

    //@return movieEncrypted
    public String getMovieEncrypted() {
        return movieEncrypted;
    }

    //@return gameOverMovie
    public String gameOverMovie() {
        return gameOverMovie;
    }

    //@return gameoverState
    public boolean gameOverState() {
        return gameOverState;
    }

    //@return score
    public int getScore() {
        return score;
    }

    /*
     * set movieTitle to String value from movies.txt file
     *
     * @param movieTitle
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /*
     * start changing the movieTitleAsterisks according to user's input
     * using playGame function in changing movieTitleAsterisks letters
     *
     * @param word from the user input in playGame activity
     */
    public String getInput(String word) {
        if (checkMovieTitle(word)) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == ' ')
                    continue;
                playGame(word.charAt(i));
            }
        } else
            score--;
        return movieTitleAsterisks.toString();
    }

    /*
     * checks if the letter is correct or not, then modify
     * movieTitleAsterisks string according to it
     *
     * param letter used by getInput
     */
    private void playGame(char letter) {
        letter = Character.toLowerCase(letter);
        isCorrect = false;
        for (int i = 0; i < movieTitle.length(); i++) {
            if (movieTitle.charAt(i) == letter && !isEntered[i]) {
                movieTitleAsterisks.setCharAt(i, letter);
                isEntered[i] = true;
                isCorrect = true;
                break;
            }
        }
        if (!isCorrect) {
            score--;
        } else {
            movieLength--;
        }
    }

    //Converts movieTitle to (*)
    private String movieAsterisks() {
        String str = "";
        for (int i = 0; i < movieTitle.length(); i++) {
            if (movieTitle.charAt(i) == ' ') {
                str += (' ');
                spaces++;
            } else {
                str += ('*');
            }
        }
        return str;
    }

    //Check if the string is in the movieTitle or not
    public boolean checkMovieTitle(String str) {
        if (movieTitle.contains(str))
            return true;
        else
            return false;
    }

    //Check if the game is over
    public boolean gameOver() {
        if (score >= 1 && movieLength != 0) {
            return false;
        }
        return true;
    }

    //Check if player won
    public void checkScore() {
        if (score >= 1) {
            gameOverState = true;
        } else {
            gameOverState = false;
        }
    }

}
package com.themovieguessing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class playGame extends AppCompatActivity {

    private int randomNumber;
    TextView movieEncrypted, movieDescription, score;
    EditText letterEntered;
    Game game = new Game();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_game);
        randomMovieNumber();
        movieEncrypted = (TextView) findViewById(R.id.movieEncrypted);
        movieDescription = (TextView) findViewById(R.id.movieDescription);
        letterEntered = (EditText) findViewById(R.id.letterEntered);
        score = (TextView) findViewById(R.id.score);
        game.setMovieTitle(randomMovie());
        game.startGame();
        movieEncrypted.setText(game.getMovieEncrypted());
        movieDescription.setText(movieDescription());
        score.setText("Wrong Guesses left : " + game.getScore());
    }

    // @return a random number using math.random() function
    private void randomMovieNumber() {
        this.randomNumber = (int) (Math.random() * 25);
    }

    // @returns random movie title
    private String randomMovie() {
        InputStream is = getResources().openRawResource(R.raw.movies);
        Scanner movieScanner;
        movieScanner = new Scanner(is);
        ArrayList<String> movies = new ArrayList<>();
        while (movieScanner.hasNextLine()) {
            String line = movieScanner.nextLine();
            movies.add(line);
        }
        movieScanner.close();
        return movies.get(randomNumber);
    }

    private String movieDescription() {
        InputStream is = getResources().openRawResource(R.raw.moviedescription);
        Scanner movieScanner;
        movieScanner = new Scanner(is);
        ArrayList<String> movies = new ArrayList<>();
        while (movieScanner.hasNextLine()) {
            String line = movieScanner.nextLine();
            movies.add(line);
        }
        movieScanner.close();
        return movies.get(randomNumber);
    }

    public void checkLetter(View view) {
        String letter = String.valueOf(letterEntered.getText());
        letter = letter.toLowerCase();
        if (letter == null || letter.isEmpty() || letter.charAt(0) == ' ') {
            letterEntered.getText().clear();
            Toast.makeText(playGame.this, "You need to enter a letter", Toast.LENGTH_SHORT).show();
            return;
        }
        movieEncrypted.setText(game.getInput(letter));
        score.setText("Wrong Guesses left : " + game.getScore());
        if (game.gameOver()) {
            game.checkScore();
            startActivity(new Intent(playGame.this, gameOver.class));
            finish();
        }
        letterEntered.getText().clear();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(playGame.this, Main.class));
        finish();
    }

    public void Restart(View view) {
        this.recreate();
    }

    public void help(View view) {
        startActivity(new Intent(playGame.this, help.class));
    }
}

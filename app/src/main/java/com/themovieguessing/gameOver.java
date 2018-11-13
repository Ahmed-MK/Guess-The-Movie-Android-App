package com.themovieguessing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class gameOver extends AppCompatActivity {

    Game gameover = new Game();
    TextView gameState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_over);
        gameState = (TextView) findViewById(R.id.gameState);
        gameOver();
    }

    private void gameOver() {
        if (gameover.gameOverState()) {
            gameState.setText("Congrats you won \nmovie was: \n\n" + gameover.gameOverMovie());
        } else {
            gameState.setText("Sorry, you lost \nmovie was: \n\n" + gameover.gameOverMovie());
        }
    }

    public void playAgain(View view) {
        startActivity(new Intent(gameOver.this, playGame.class));
        finish();
    }

    public void mainMenu(View view) {
        startActivity(new Intent(gameOver.this, Main.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(gameOver.this, Main.class));
        finish();
    }

}

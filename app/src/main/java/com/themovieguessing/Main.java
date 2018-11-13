package com.themovieguessing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    //when the user start playing the game
    public void startGame(View view) {
        startActivity(new Intent(Main.this, playGame.class));
        finish();
    }

    // view the help document to the user
    public void help(View view) {
        startActivity(new Intent(Main.this, help.class));
    }
}

package com.themovieguessing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class help extends AppCompatActivity {

    TextView help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        help = (TextView) findViewById(R.id.help);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

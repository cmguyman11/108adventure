package edu.stanford.cs108.bunnyworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Santiago Test
    }

    public void play(View view){
        Intent intent = new Intent(this,PlayGameOptions.class);
        startActivity(intent);
    }

    public void edit(View view){
        Intent intent = new Intent(this,EditGame.class);
        startActivity(intent);
    }
}

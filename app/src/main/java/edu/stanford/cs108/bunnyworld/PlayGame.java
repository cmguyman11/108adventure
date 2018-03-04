package edu.stanford.cs108.bunnyworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PlayGame extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        //Gets the ID of the game that is currently being played.
        Intent intent = getIntent();
        int game_id = intent.getIntExtra("GAME_ID", 0);

        //This is just for testing
        TextView txt = (TextView) findViewById(R.id.test_textview);
        txt.setText("Currently playing game: " + Integer.toString(game_id) + "");
    }
}

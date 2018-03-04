package edu.stanford.cs108.bunnyworld;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PlayGameOptions extends AppCompatActivity {
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game_options);

        //Creates a test table to see if our adapter works
        String setUpStr = "CREATE TABLE games ("
                + "game TEXT, "
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT);";

        String testTable = "INSERT INTO games VALUES " +
                "('game1', NULL)," +
                "('game2', NULL)," +
                "('game3', NULL);";

        db = openOrCreateDatabase("gamesDB", MODE_PRIVATE,null);
        Cursor tablesCursor = db.rawQuery("SELECT name FROM sqlite_master " +
                "WHERE type='table' AND name='games'", null);

        if(tablesCursor.getCount() == 0) {
            db.execSQL(setUpStr);
            db.execSQL(testTable);
        }

        Cursor cursor = db.rawQuery("SELECT * FROM games", null);
        String[] gamesArray = new String[cursor.getCount()];
        int i = 0;
        while(cursor.moveToNext()){
            String game = cursor.getString(cursor.getColumnIndex("game"));
            gamesArray[i] = game;
            i ++;
        }

        ListView listView = (ListView) findViewById(R.id.games_listView);
        ListAdapter adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_single_choice,
                gamesArray);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
    }

    public void playSelectedGame(View view){
        ListView listView = (ListView) findViewById(R.id.games_listView);
        int index = listView.getCheckedItemPosition();
        int game_id = 0;
        Cursor cursor = db.rawQuery("SELECT * FROM games WHERE rowid = " + index + ";", null);
        if(cursor.moveToFirst()) {
            game_id = cursor.getInt(cursor.getColumnIndex("_id"));
        }

        Intent intent = new Intent(this,PlayGame.class);
        intent.putExtra("GAME_ID", game_id);
        startActivity(intent);

    }
}

package com.example.thellamapaul.r8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class NewReview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_review);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        final TextView textView_score = (TextView) findViewById(R.id.textView_score);
        final EditText editText_album = (EditText) findViewById(R.id.editText_album);
        final EditText editText_artist = (EditText) findViewById(R.id.editText_artist);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        Button button_findArtwork = (Button) findViewById(R.id.button_findArtwork);
        Button button_save = (Button) findViewById(R.id.button_save);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                textView_score.setText(" Score: " + progress +  "/10");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });


        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("album", editText_album.getText().toString());
                returnIntent.putExtra("artist", editText_artist.getText().toString());
                returnIntent.putExtra("score", seekBar.getProgress());
                setResult(1, returnIntent);
                finish();
            }
        });
    }

}

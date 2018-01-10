package com.example.thellamapaul.r8;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Review extends AppCompatActivity {

    List<Integer> IMAGES = new ArrayList<Integer>();
    List<String> ARTISTS = new ArrayList<String>();
    List<String> ALBUMS = new ArrayList<String>();
    List<Integer> SCORES= new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //populate
        IMAGES.add(R.drawable.girlpool_btwwb_560x560);
        IMAGES.add(R.drawable.strfkr_bnogn);
        ARTISTS.add("Girlpool");
        ARTISTS.add("STRFKR");
        ALBUMS.add("Before the World was Big");
        ALBUMS.add("Being No One, Going Nowhere");
        SCORES.add(10);
        SCORES.add(6);

        //List
        ListView listView = (ListView) findViewById(R.id.listView);
        final CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

        //Floating Action Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Review.this, NewReview.class);
                startActivityForResult(intent, 1);
                //TODO: update album list after new album
                //customAdapter.notifyDataSetChanged();
            }
        });

        //Debug
        //TextView textView_debug = (TextView) findViewById(R.id.textView_debug);
        //textView_debug.setText(ALBUMS.size());

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                //ALBUMS.add(data.getStringExtra("album"));
                //ARTISTS.add(data.getStringExtra("artist"));
                //SCORES.add(data.getIntExtra("score", 0));
                //IMAGES.add(NULL);
            }
            if(resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return ALBUMS.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout_review, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView textView_album = (TextView) view.findViewById(R.id.textView_album);
            TextView textView_artist = (TextView) view.findViewById(R.id.textView_artist);
            TextView textView_ten = (TextView) view.findViewById(R.id.textView_ten);

            imageView.setImageResource(IMAGES.get(i));
            textView_album.setText(ALBUMS.get(i));
            textView_artist.setText(ARTISTS.get(i));
            textView_ten.setText(SCORES.get(i) + "/10");

            return view;
        }
    }

}

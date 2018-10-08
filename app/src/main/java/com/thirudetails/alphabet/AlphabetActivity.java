package com.thirudetails.alphabet;

import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class AlphabetActivity extends AppCompatActivity {

    private ViewPager viewPager;
    ArrayList<String> imagePaths;
    ImageOpenAdapter adapter;

    int [] songs = {R.raw.pack1s1, R.raw.pack1s2, R.raw.pack1s3, R.raw.pack1s4, R.raw.pack1s5,
            R.raw.pack1s6, R.raw.pack1s7, R.raw.pack1s8, R.raw.pack1s9, R.raw.pack1s10,
            R.raw.pack1s11, R.raw.pack1s12, R.raw.pack1s13, R.raw.pack1s14, R.raw.pack1s15,
            R.raw.pack1s16, R.raw.pack1s17, R.raw.pack1s18, R.raw.pack1s19, R.raw.pack1s20,
            R.raw.pack1s21, R.raw.pack1s22, R.raw.pack1s23, R.raw.pack1s24, R.raw.pack1s25,R.raw.pack1s26};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alphabet);
        imagePaths = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        String pos = getIntent().getStringExtra(Constants.KEY_ARRAY_IMAGE);
        adapter = new ImageOpenAdapter(AlphabetActivity.this, imagePaths);
        viewPager.setAdapter(adapter);

        viewPager.setCurrentItem(Integer.parseInt(Constants.getPrefernc(this, Constants.POSITION)), true);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_play, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection

        switch (item.getItemId()) {
            case R.id.menu_play:
                MediaPlayer mediaPlayer= MediaPlayer.create(this,songs[viewPager.getCurrentItem()]);

                mediaPlayer.start();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return false;
    }
}

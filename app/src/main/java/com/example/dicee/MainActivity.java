package com.example.dicee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int[] images = {R.drawable.dice1, R.drawable.dice2,
            R.drawable.dice3, R.drawable.dice4,
            R.drawable.dice5, R.drawable.dice6};

    private int generateRandomInteger(){
        return (int) (Math.random() * 6);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        final ImageView imageViewLeft = (ImageView) findViewById(R.id.dicee_image_left_id);
        final ImageView imageViewRight = (ImageView) findViewById(R.id.dicee_right_image_id);

        imageViewLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Left Image Clicked !", Toast.LENGTH_SHORT).show();
                imageViewLeft.setImageResource(images[generateRandomInteger()]);
            }
        });

        imageViewRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, " Right Image Clicked !", Toast.LENGTH_SHORT).show();
                Log.i("tag",generateRandomInteger()+"");
                imageViewRight.setImageResource(images[generateRandomInteger()]);
            }
        });
    }
}

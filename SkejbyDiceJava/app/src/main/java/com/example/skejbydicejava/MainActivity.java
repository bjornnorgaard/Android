package com.example.skejbydicejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDie1;
    private ImageView imageViewDie2;
    private Button rollButton;
    private Random rng = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewDie1 = findViewById(R.id.image_view_die1);
        imageViewDie2 = findViewById(R.id.image_view_die2);

        rollButton = findViewById(R.id.roll_button);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDie(imageViewDie1);
                rollDie(imageViewDie2);
            }
        });
    }

    private void rollDie(ImageView imageViewDie) {
        int randomNumber = rng.nextInt(6)+1;

        switch (randomNumber) {
            case 1:
                imageViewDie.setImageResource(R.drawable.d1);
                break;
            case 2:
                imageViewDie.setImageResource(R.drawable.d2);
                break;
            case 3:
                imageViewDie.setImageResource(R.drawable.d3);
                break;
            case 4:
                imageViewDie.setImageResource(R.drawable.d4);
                break;
            case 5:
                imageViewDie.setImageResource(R.drawable.d5);
                break;
            case 6:
                imageViewDie.setImageResource(R.drawable.d6);
                break;


        }
    }
}

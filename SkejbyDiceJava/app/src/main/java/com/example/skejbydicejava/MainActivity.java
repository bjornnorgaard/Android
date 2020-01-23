package com.example.skejbydicejava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/*
    This game has XXX phases:
    Phase 0: Roll first time for attacking

 */

public class MainActivity extends AppCompatActivity {
    private ImageView imageViewDie1, imageViewDie2;
    private ImageView imageViewPos2, imageViewPos3, imageViewPos4;
    private Button rollButton;
    private int attackDie1, attackDie2;
    private Random rng = new Random();
    private TextView playerSips, opp1Sips, opp2Sips, opp3Sips;
    private TextView textViewPos1Name, textViewPos2Name, textViewPos3Name, textViewPos4Name;
    private Player player1, player2, player3, player4;
    private MediaPlayer diceRollSound;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceRollSound = MediaPlayer.create(MainActivity.this, R.raw.diceroll);

        player1 = new Player("Søren", 1);
        player2 = new Player("Nikolaj", 2);
        player3 = new Player("Bjørn", 3);
        player4 = new Player("Christian", 4);

        setUpComponents();
        setDefaultValues();
        setClickListeners();


    }

    private void placePlayer(Player p) {
        switch (p.getPos()) {
            case 1:
                textViewPos1Name.setText(p.getName());
                break;
            case 2:
                textViewPos2Name.setText(p.getName());
                break;
            case 3:
                textViewPos3Name.setText(p.getName());
                break;
            case 4:
                textViewPos4Name.setText(p.getName());
                break;
        }

    }

    private void setClickListeners() {
        imageViewPos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack(player2, attackValue());
            }
        });

        imageViewPos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack(player3, attackValue());
            }
        });

        imageViewPos4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack(player4, attackValue());
            }
        });

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attackDie1 = rollDie(imageViewDie1);
                attackDie2 = rollDie(imageViewDie2);
                rollButton.setEnabled(false);
                imageViewPos2.setEnabled(true);
                imageViewPos3.setEnabled(true);
                imageViewPos4.setEnabled(true);
            }
        });
    }

    private void setDefaultValues() {
        rollButton.setEnabled(true);
        imageViewPos2.setEnabled(false);
        imageViewPos3.setEnabled(false);
        imageViewPos4.setEnabled(false);
    }

    private void setUpComponents() {
        textViewPos1Name = findViewById(R.id.text_view_pos1Name);
        textViewPos2Name = findViewById(R.id.text_view_pos2Name);
        textViewPos3Name = findViewById(R.id.text_view_pos3Name);
        textViewPos4Name = findViewById(R.id.text_view_pos4Name);

        placePlayer(player1);
        placePlayer(player2);
        placePlayer(player3);
        placePlayer(player4);

/*
        textViewPos1Name.setText(player1.getName());
        textViewPos2Name.setText(player2.getName());
        textViewPos3Name.setText(player3.getName());
        textViewPos4Name.setText(player4.getName());

 */

        playerSips = findViewById(R.id.text_view_pos1Sips);
        opp1Sips = findViewById(R.id.text_view_pos2Sips);
        opp2Sips = findViewById(R.id.text_view_pos3Sips);
        opp3Sips = findViewById(R.id.text_view_pos4Sips);

        imageViewDie1 = findViewById(R.id.image_view_die1);
        imageViewDie2 = findViewById(R.id.image_view_die2);

        imageViewPos2 = findViewById(R.id.image_view_opp1);
        imageViewPos3 = findViewById(R.id.image_view_opp2);
        imageViewPos4 = findViewById(R.id.image_view_opp3);

        rollButton = findViewById(R.id.roll_button);
    }


    private int attackValue() {
        return (attackDie1 + attackDie2) / 2;
    }

    private void attack(Player p, int sips) {
        p.addSips(sips);
        updateSips();
        rollButton.setEnabled(true);
        imageViewPos2.setEnabled(false);
        imageViewPos3.setEnabled(false);
        imageViewPos4.setEnabled(false);
    }

    private void updateSips() {
        playerSips.setText("" + player1.getSips());
        opp1Sips.setText("" + player2.getSips());
        opp2Sips.setText("" + player3.getSips());
        opp3Sips.setText("" + player4.getSips());
    }

    private int rollDie(ImageView imageViewDie) {
        diceRollSound.start();
        int randomNumber = rng.nextInt(6) + 1;

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
        return randomNumber;
    }
}

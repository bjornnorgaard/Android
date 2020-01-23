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
    private TextView textViewPos1Sips, textViewPos2Sips, textViewPos3Sips, textViewPos4Sips;
    private TextView textViewPos1Name, textViewPos2Name, textViewPos3Name, textViewPos4Name;
    private Player player1, player2, player3, player4;
    private Player pos1Player, pos2Player, pos3Player, pos4Player;
    private MediaPlayer diceRollSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceRollSound = MediaPlayer.create(MainActivity.this, R.raw.diceroll);

        player1 = new Player("Søren", 1, R.drawable.token1);
        player2 = new Player("Nikolaj", 2, R.drawable.token2);
        player3 = new Player("Bjørn", 3, R.drawable.token3);
        player4 = new Player("Christian", 4, R.drawable.token4);

        setUpComponents();

        setDefaultValues();

        placePlayers();

        setClickListeners();


    }

    private void placePlayers() {
        placePlayer(player1);
        placePlayer(player2);
        placePlayer(player3);
        placePlayer(player4);
    }

    private void placePlayer(Player p) {
        switch (p.getPos()) {
            case 1:
                textViewPos1Name.setText(p.getName());
                textViewPos1Sips.setText(""+p.getSips());
                pos1Player = p;
                break;
            case 2:
                textViewPos2Name.setText(p.getName());
                textViewPos2Sips.setText(""+p.getSips());
                imageViewPos2.setImageResource(p.getToken());
                pos2Player = p;
                break;
            case 3:
                textViewPos3Name.setText(p.getName());
                textViewPos3Sips.setText(""+p.getSips());
                imageViewPos3.setImageResource(p.getToken());
                pos3Player = p;
                break;
            case 4:
                    textViewPos4Name.setText(p.getName());
                textViewPos4Sips.setText(""+p.getSips());
                imageViewPos4.setImageResource(p.getToken());
    pos4Player = p;
                break;
}
    }

    private void setClickListeners() {
        imageViewPos2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack(pos2Player, attackValue());
            }
        });

        imageViewPos3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack(pos3Player, attackValue());
            }
        });

        imageViewPos4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attack(pos4Player, attackValue());
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

        textViewPos1Sips = findViewById(R.id.text_view_pos1Sips);
        textViewPos2Sips = findViewById(R.id.text_view_pos2Sips);
        textViewPos3Sips = findViewById(R.id.text_view_pos3Sips);
        textViewPos4Sips = findViewById(R.id.text_view_pos4Sips);

        imageViewDie1 = findViewById(R.id.image_view_die1);
        imageViewDie2 = findViewById(R.id.image_view_die2);

        imageViewPos2 = findViewById(R.id.image_view_pos2);
        imageViewPos3 = findViewById(R.id.image_view_pos3);
        imageViewPos4 = findViewById(R.id.image_view_pos4);

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
        textViewPos1Sips.setText("" + player1.getSips());
        textViewPos2Sips.setText("" + player2.getSips());
        textViewPos3Sips.setText("" + player3.getSips());
        textViewPos4Sips.setText("" + player4.getSips());
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

package com.thcloc.gamebaicao_17041281;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Card> ListPlayingCard = new ArrayList<>();
    boolean isChiaBai = false;

    Button btnChiaBai;

    ImageView Card_May_01;
    ImageView Card_May_02;
    ImageView Card_May_03;
    ImageView Card_Nguoi_01;
    ImageView Card_Nguoi_02;
    ImageView Card_Nguoi_03;

    ArrayList<Card> PLayer01_ListCard;
    ArrayList<Card> PLayer02_ListCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Init_Data();
        btnChiaBai_Click();
    }

    protected void Init_Data() {
        Init_PlayingCard();

        btnChiaBai = (Button) findViewById(R.id.btnChiaBai);

        Card_May_01 = (ImageView) findViewById(R.id.card_may_01);
        Card_May_02 = (ImageView) findViewById(R.id.card_may_02);
        Card_May_03 = (ImageView) findViewById(R.id.card_may_03);

        Card_Nguoi_01 = (ImageView) findViewById(R.id.card_nguoi_01);
        Card_Nguoi_02 = (ImageView) findViewById(R.id.card_nguoi_02);
        Card_Nguoi_03 = (ImageView) findViewById(R.id.card_nguoi_03);
    }

    protected void Init_PlayingCard(){
        //02
        ListPlayingCard.add(new Card("2","h", R.drawable.h2));
        ListPlayingCard.add(new Card("2","d", R.drawable.d2));
        ListPlayingCard.add(new Card("2","c", R.drawable.c2));
        ListPlayingCard.add(new Card("2","s", R.drawable.s2));

        //03
        ListPlayingCard.add(new Card("3","h", R.drawable.h3));
        ListPlayingCard.add(new Card("3","d", R.drawable.d3));
        ListPlayingCard.add(new Card("3","c", R.drawable.c3));
        ListPlayingCard.add(new Card("3","s", R.drawable.s3));

        //04
        ListPlayingCard.add(new Card("4","h", R.drawable.h4));
        ListPlayingCard.add(new Card("4","d", R.drawable.d4));
        ListPlayingCard.add(new Card("4","c", R.drawable.c4));
        ListPlayingCard.add(new Card("4","s", R.drawable.s4));

        //05
        ListPlayingCard.add(new Card("5","h", R.drawable.h5));
        ListPlayingCard.add(new Card("5","d", R.drawable.d5));
        ListPlayingCard.add(new Card("5","c", R.drawable.c5));
        ListPlayingCard.add(new Card("5","s", R.drawable.s5));

        //06
        ListPlayingCard.add(new Card("6","h", R.drawable.h6));
        ListPlayingCard.add(new Card("6","d", R.drawable.d6));
        ListPlayingCard.add(new Card("6","c", R.drawable.c6));
        ListPlayingCard.add(new Card("6","s", R.drawable.s6));

        //07
        ListPlayingCard.add(new Card("7","h", R.drawable.h7));
        ListPlayingCard.add(new Card("7","d", R.drawable.d7));
        ListPlayingCard.add(new Card("7","c", R.drawable.c7));
        ListPlayingCard.add(new Card("7","s", R.drawable.s7));

        //08
        ListPlayingCard.add(new Card("8","h", R.drawable.h8));
        ListPlayingCard.add(new Card("8","d", R.drawable.d8));
        ListPlayingCard.add(new Card("8","c", R.drawable.c8));
        ListPlayingCard.add(new Card("8","s", R.drawable.s8));

        //09
        ListPlayingCard.add(new Card("9","h", R.drawable.h9));
        ListPlayingCard.add(new Card("9","d", R.drawable.d9));
        ListPlayingCard.add(new Card("9","c", R.drawable.c9));
        ListPlayingCard.add(new Card("9","s", R.drawable.s9));

        //10
        ListPlayingCard.add(new Card("10","h", R.drawable.h10));
        ListPlayingCard.add(new Card("10","d", R.drawable.d10));
        ListPlayingCard.add(new Card("10","c", R.drawable.c10));
        ListPlayingCard.add(new Card("10","s", R.drawable.s10));

        //J
        ListPlayingCard.add(new Card("j","h", R.drawable.hj));
        ListPlayingCard.add(new Card("j","d", R.drawable.dj));
        ListPlayingCard.add(new Card("j","c", R.drawable.cj));
        ListPlayingCard.add(new Card("j","s", R.drawable.sj));

        //Q
        ListPlayingCard.add(new Card("q","h", R.drawable.hq));
        ListPlayingCard.add(new Card("q","d", R.drawable.dq));
        ListPlayingCard.add(new Card("q","c", R.drawable.cq));
        ListPlayingCard.add(new Card("q","s", R.drawable.sq));

        //K
        ListPlayingCard.add(new Card("k","h", R.drawable.hk));
        ListPlayingCard.add(new Card("k","d", R.drawable.dk));
        ListPlayingCard.add(new Card("k","c", R.drawable.ck));
        ListPlayingCard.add(new Card("k","s", R.drawable.sk));

        //Ace
        ListPlayingCard.add(new Card("a","h", R.drawable.ha));
        ListPlayingCard.add(new Card("a","d", R.drawable.da));
        ListPlayingCard.add(new Card("a","c", R.drawable.ca));
        ListPlayingCard.add(new Card("a","s", R.drawable.sa));
    }

    protected void btnChiaBai_Click() {
        btnChiaBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChiaBai == false){
                    Card_May_01.setImageResource(R.drawable.background);
                    Card_May_02.setImageResource(R.drawable.background);
                    Card_May_03.setImageResource(R.drawable.background);

                    Card_Nguoi_01.setImageResource(R.drawable.background);
                    Card_Nguoi_02.setImageResource(R.drawable.background);
                    Card_Nguoi_03.setImageResource(R.drawable.background);

                    isChiaBai = true;
                }else {
                    Card_May_01.setImageResource(android.R.color.transparent);
                    Card_May_02.setImageResource(android.R.color.transparent);
                    Card_May_03.setImageResource(android.R.color.transparent);

                    Card_Nguoi_01.setImageResource(android.R.color.transparent);
                    Card_Nguoi_02.setImageResource(android.R.color.transparent);
                    Card_Nguoi_03.setImageResource(android.R.color.transparent);

                    isChiaBai = false;
                }

                ChiaBai();
                btnChiaBai.setText("Ván Mới");
            }
        });
    }

    protected void ChiaBai(){
        Random random = new Random();

        for (int i = 0; i < 6; i++){
            if(i%2 == 0){
                Log.e("Chia Het 2", ListPlayingCard.get(random.nextInt(52)).getValue());
            }  else {
                Log.e("Chia Khong Het 2", ListPlayingCard.get(random.nextInt(52)).getValue());
            }
        }
    }
}
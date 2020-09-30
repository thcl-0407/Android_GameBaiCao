package com.thcloc.gamebaicao_17041281;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ArrayList<Card> ListPlayingCard = new ArrayList<>();

    //Kiểm tra Người Chơi Bấm Nút Chia Bài Chưa
    boolean isChiaBai = false;

    //Kiểm Tra Người Chơi Đã Mở Hết Bài Chưa
    int isDone_MoBai = 0;

    //Chế Độ Chơi
    //Người vs Máy = 0
    //Người vs Người = 1
    //Máy vs Máy = 2
    int CheDoChoi = 0;

    int Diem_Player01 = 0;
    int Diem_Player02 = 0;

    Button btnChiaBai;

    ImageView Card_May_01;
    ImageView Card_May_02;
    ImageView Card_May_03;
    ImageView Card_Nguoi_01;
    ImageView Card_Nguoi_02;
    ImageView Card_Nguoi_03;

    TextView txtDiem_Player01;
    TextView txtDiem_Player02;

    ArrayList<Card> PLayer01_ListCard;
    ArrayList<Card> PLayer02_ListCard;

    LinearLayout container_logo_winner_player01;
    LinearLayout container_logo_winner_player02;

    ImageView logo_winner_player01;
    ImageView logo_winner_player02;

    TextView logo_draw_player01;
    TextView logo_draw_player02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PLayer01_ListCard = new ArrayList<>();
        PLayer02_ListCard = new ArrayList<>();

        Init_Data();
        btnChiaBai_Click();

        Card_May_01_Click();
        Card_May_02_Click();
        Card_May_03_Click();
        Card_Nguoi_01_Click();
        Card_Nguoi_02_Click();
        Card_Nguoi_03_Click();
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

        txtDiem_Player01 = (TextView) findViewById(R.id.txtDiem_Player01);
        txtDiem_Player02 = (TextView) findViewById(R.id.txtDiem_Player02);

        container_logo_winner_player01 = (LinearLayout) findViewById(R.id.container_logo_winner_player01);
        container_logo_winner_player02 = (LinearLayout) findViewById(R.id.container_logo_winner_player02);

        logo_winner_player01 = (ImageView) findViewById(R.id.logo_winner_player01);
        logo_winner_player02 = (ImageView) findViewById(R.id.logo_winner_player02);

        logo_draw_player01 = (TextView) findViewById(R.id.logo_draw_player01);
        logo_draw_player02 = (TextView) findViewById(R.id.logo_draw_player02);

        Control_Card_ON_OFF(false, false);
    }

    protected void Init_PlayingCard() {
        //02
        ListPlayingCard.add(new Card("2", "h", R.drawable.h2));
        ListPlayingCard.add(new Card("2", "d", R.drawable.d2));
        ListPlayingCard.add(new Card("2", "c", R.drawable.c2));
        ListPlayingCard.add(new Card("2", "s", R.drawable.s2));

        //03
        ListPlayingCard.add(new Card("3", "h", R.drawable.h3));
        ListPlayingCard.add(new Card("3", "d", R.drawable.d3));
        ListPlayingCard.add(new Card("3", "c", R.drawable.c3));
        ListPlayingCard.add(new Card("3", "s", R.drawable.s3));

        //04
        ListPlayingCard.add(new Card("4", "h", R.drawable.h4));
        ListPlayingCard.add(new Card("4", "d", R.drawable.d4));
        ListPlayingCard.add(new Card("4", "c", R.drawable.c4));
        ListPlayingCard.add(new Card("4", "s", R.drawable.s4));

        //05
        ListPlayingCard.add(new Card("5", "h", R.drawable.h5));
        ListPlayingCard.add(new Card("5", "d", R.drawable.d5));
        ListPlayingCard.add(new Card("5", "c", R.drawable.c5));
        ListPlayingCard.add(new Card("5", "s", R.drawable.s5));

        //06
        ListPlayingCard.add(new Card("6", "h", R.drawable.h6));
        ListPlayingCard.add(new Card("6", "d", R.drawable.d6));
        ListPlayingCard.add(new Card("6", "c", R.drawable.c6));
        ListPlayingCard.add(new Card("6", "s", R.drawable.s6));

        //07
        ListPlayingCard.add(new Card("7", "h", R.drawable.h7));
        ListPlayingCard.add(new Card("7", "d", R.drawable.d7));
        ListPlayingCard.add(new Card("7", "c", R.drawable.c7));
        ListPlayingCard.add(new Card("7", "s", R.drawable.s7));

        //08
        ListPlayingCard.add(new Card("8", "h", R.drawable.h8));
        ListPlayingCard.add(new Card("8", "d", R.drawable.d8));
        ListPlayingCard.add(new Card("8", "c", R.drawable.c8));
        ListPlayingCard.add(new Card("8", "s", R.drawable.s8));

        //09
        ListPlayingCard.add(new Card("9", "h", R.drawable.h9));
        ListPlayingCard.add(new Card("9", "d", R.drawable.d9));
        ListPlayingCard.add(new Card("9", "c", R.drawable.c9));
        ListPlayingCard.add(new Card("9", "s", R.drawable.s9));

        //10
        ListPlayingCard.add(new Card("10", "h", R.drawable.h10));
        ListPlayingCard.add(new Card("10", "d", R.drawable.d10));
        ListPlayingCard.add(new Card("10", "c", R.drawable.c10));
        ListPlayingCard.add(new Card("10", "s", R.drawable.s10));

        //J
        ListPlayingCard.add(new Card("j", "h", R.drawable.hj));
        ListPlayingCard.add(new Card("j", "d", R.drawable.dj));
        ListPlayingCard.add(new Card("j", "c", R.drawable.cj));
        ListPlayingCard.add(new Card("j", "s", R.drawable.sj));

        //Q
        ListPlayingCard.add(new Card("q", "h", R.drawable.hq));
        ListPlayingCard.add(new Card("q", "d", R.drawable.dq));
        ListPlayingCard.add(new Card("q", "c", R.drawable.cq));
        ListPlayingCard.add(new Card("q", "s", R.drawable.sq));

        //K
        ListPlayingCard.add(new Card("k", "h", R.drawable.hk));
        ListPlayingCard.add(new Card("k", "d", R.drawable.dk));
        ListPlayingCard.add(new Card("k", "c", R.drawable.ck));
        ListPlayingCard.add(new Card("k", "s", R.drawable.sk));

        //Ace
        ListPlayingCard.add(new Card("a", "h", R.drawable.ha));
        ListPlayingCard.add(new Card("a", "d", R.drawable.da));
        ListPlayingCard.add(new Card("a", "c", R.drawable.ca));
        ListPlayingCard.add(new Card("a", "s", R.drawable.sa));
    }

    protected void btnChiaBai_Click() {
        btnChiaBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChiaBai == false) {
                    //Bắt Đầu Chia Bài
                    ChiaBai();

                    Card_May_01.setImageResource(R.drawable.background);
                    Card_May_02.setImageResource(R.drawable.background);
                    Card_May_03.setImageResource(R.drawable.background);

                    Card_Nguoi_01.setImageResource(R.drawable.background);
                    Card_Nguoi_02.setImageResource(R.drawable.background);
                    Card_Nguoi_03.setImageResource(R.drawable.background);

                    //Config Chế Độ Chơi
                    if(CheDoChoi == 0){
                        Control_Card_ON_OFF(false, true);
                    }

                    isChiaBai = true;
                    btnChiaBai.setText("Ván Mới");
                } else {
                    //Reset Ván Mới
                    Card_May_01.setImageResource(android.R.color.transparent);
                    Card_May_02.setImageResource(android.R.color.transparent);
                    Card_May_03.setImageResource(android.R.color.transparent);

                    Card_Nguoi_01.setImageResource(android.R.color.transparent);
                    Card_Nguoi_02.setImageResource(android.R.color.transparent);
                    Card_Nguoi_03.setImageResource(android.R.color.transparent);

                    isChiaBai = false;
                    btnChiaBai.setText("Chia Bài");
                    isDone_MoBai = 0;
                    PLayer01_ListCard.clear();
                    PLayer02_ListCard.clear();

                    //Xử Lý Các Logo Thông Báo End Game
                    container_logo_winner_player01.setVisibility(View.GONE);
                    container_logo_winner_player02.setVisibility(View.GONE);
                    logo_winner_player01.setVisibility(View.GONE);
                    logo_winner_player02.setVisibility(View.GONE);
                    logo_draw_player01.setVisibility(View.GONE);
                    logo_draw_player02.setVisibility(View.GONE);
                }
            }
        });
    }
    //---------------------------------------------------

    protected void Card_May_01_Click(){}
    protected void Card_May_02_Click(){}
    protected void Card_May_03_Click(){}

    protected void Card_Nguoi_01_Click(){
        Card_Nguoi_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lỗi Chưa Click Chia Bài
                if(PLayer02_ListCard.size() == 0){
                    return;
                }

                Card card = PLayer02_ListCard.get(0);

                //Chế Độ Chơi Người vs Máy
                if(CheDoChoi == 0){
                    Card_Nguoi_01.setImageResource(card.getIMG_SRC());
                    Card_Nguoi_01.setEnabled(false);
                    isDone_MoBai += 1;

                    //Xử Lý End Game --- Mở Hết Bài
                    if(isDone_MoBai == 3){
                        Show_Player_EndGame(CheDoChoi, WhoIsWinner(CheDoChoi));
                    }
                }

                //Chế Độ Chơi Người vs Người
                if(CheDoChoi == 1){

                }
            }
        });
    }

    protected void Card_Nguoi_02_Click(){
        Card_Nguoi_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lỗi Chưa Click Chia Bài
                if(PLayer02_ListCard.size() == 0){
                    return;
                }

                Card card = PLayer02_ListCard.get(1);

                //Chế Độ Chơi Người vs Máy
                if(CheDoChoi == 0){
                    Card_Nguoi_02.setImageResource(card.getIMG_SRC());
                    Card_Nguoi_02.setEnabled(false);
                    isDone_MoBai += 1;


                    //Xử Lý End Game --- Mở Hết Bài
                    if(isDone_MoBai == 3){
                        Show_Player_EndGame(CheDoChoi, WhoIsWinner(CheDoChoi));
                    }
                }

                //Chế Độ Chơi Người vs Người
                if(CheDoChoi == 1){

                }
            }
        });
    }

    protected void Card_Nguoi_03_Click(){
        Card_Nguoi_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Lỗi Chưa Click Chia Bài
                if(PLayer02_ListCard.size() == 0){
                    return;
                }

                Card card = PLayer02_ListCard.get(2);

                //Chế Độ Chơi Người vs Máy
                if(CheDoChoi == 0){
                    Card_Nguoi_03.setImageResource(card.getIMG_SRC());
                    Card_Nguoi_03.setEnabled(false);
                    isDone_MoBai += 1;

                    //Xử Lý End Game --- Mở Hết Bài
                    if(isDone_MoBai == 3){
                        Show_Player_EndGame(CheDoChoi, WhoIsWinner(CheDoChoi));
                    }
                }

                //Chế Độ Chơi Người vs Người
                if(CheDoChoi == 1){

                }
            }
        });
    }

    //------------------------------------------------------
    //Xử Lý Chơi

    //Control ON_OFF Card theo Chế Độ Chơi
    protected void Control_Card_ON_OFF(boolean key_player01, boolean key_player02){
        Card_May_01.setEnabled(key_player01);
        Card_May_02.setEnabled(key_player01);
        Card_May_03.setEnabled(key_player01);

        Card_Nguoi_01.setEnabled(key_player02);
        Card_Nguoi_02.setEnabled(key_player02);
        Card_Nguoi_03.setEnabled(key_player02);
    }

    //Get Số Ngẫu Nhiên
    protected int BAI_NGAU_NHIEN() {
        Random random = new Random();
        return random.nextInt(51);
    }


    protected void ChiaBai() {
        int temp_01, temp_02;

        for (int i = 0; i < 3; i++) {
            if (PLayer01_ListCard.size() > 0 && PLayer02_ListCard.size() > 0) {
                temp_01 = BAI_NGAU_NHIEN();
                PLayer01_ListCard.add(ListPlayingCard.get(temp_01));

                while (true) {
                    temp_02 = BAI_NGAU_NHIEN();

                    if (temp_01 != temp_02) {
                        PLayer02_ListCard.add(ListPlayingCard.get(temp_02));
                        break;
                    }
                }
            } else {
                //Chọn Lá Bài Đầu Tiên
                temp_01 = BAI_NGAU_NHIEN();
                PLayer01_ListCard.add(ListPlayingCard.get(temp_01));

                while (true) {
                    temp_02 = BAI_NGAU_NHIEN();

                    if (temp_01 != temp_02) {
                        PLayer02_ListCard.add(ListPlayingCard.get(temp_02));
                        break;
                    }
                }
            }
        }
    }

    //Get Người Chiến Thắng
    protected int WhoIsWinner(int CheDoChoi){
        //Chế độ chơi Người vs Máy
        if(CheDoChoi == 0 && isDone_MoBai == 3){
            String Diem_Player01, Diem_Player02;

            Diem_Player01 = Integer.toString(GetScore_Player(PLayer01_ListCard));
            Diem_Player02 = Integer.toString(GetScore_Player(PLayer02_ListCard));

            //Lấy Giá Trị Cuối
            Diem_Player01 = Character.toString(Diem_Player01.charAt(Diem_Player01.length() - 1));
            Diem_Player02 = Character.toString(Diem_Player02.charAt(Diem_Player02.length() - 1));

            switch (Integer.compare(Integer.parseInt(Diem_Player01), Integer.parseInt(Diem_Player02))){
                //Nếu Player 02 Win ---> 0
                case -1:
                    return 0;
                //Nếu Hoà ---> 2
                case 0:
                    return 2;
                //Nếu Player 01 Win ---> 1
                case 1:
                    return 1;
            }
        }

        return -1;
    }

    //Get Điểm
    protected int ConvertStringValue_toInteger(String Card_Value){
        switch (Card_Value){
            case "a":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "j":
                return 10;
            case "q":
                return 10;
            case "k":
                return 10;
        }

        return -1;
    }

    //Tính Điểm Người Chơi
    protected int GetScore_Player(ArrayList<Card> cards){
        int Card01_Value = ConvertStringValue_toInteger(cards.get(0).getValue());
        int Card02_Value = ConvertStringValue_toInteger(cards.get(1).getValue());
        int Card03_Value = ConvertStringValue_toInteger(cards.get(2).getValue());

        return (Card01_Value + Card02_Value + Card03_Value);
    }

    //Show All Card_Player
    protected void Show_Player_EndGame(int CheDoChoi, int winner){
        if(CheDoChoi == 0){
            Card_May_01.setImageResource(PLayer01_ListCard.get(0).getIMG_SRC());
            Card_May_02.setImageResource(PLayer01_ListCard.get(1).getIMG_SRC());
            Card_May_03.setImageResource(PLayer01_ListCard.get(2).getIMG_SRC());

            //Player 02 Winner
            if(winner == 0){
                Diem_Player02 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                container_logo_winner_player02.setVisibility(View.VISIBLE);
                logo_winner_player02.setVisibility(View.VISIBLE);
            }

            //Player 01 Winner
            if(winner == 1){
                Diem_Player01 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                container_logo_winner_player01.setVisibility(View.VISIBLE);
                logo_winner_player01.setVisibility(View.VISIBLE);
            }

            //Hoà Nhau
            if(winner == 2){
                container_logo_winner_player01.setVisibility(View.VISIBLE);
                container_logo_winner_player02.setVisibility(View.VISIBLE);
                logo_draw_player01.setVisibility(View.VISIBLE);
                logo_draw_player02.setVisibility(View.VISIBLE);
            }
        }
        if(CheDoChoi == 1){

        }
        if (CheDoChoi == 2){
            Card_May_01.setImageResource(PLayer01_ListCard.get(0).getIMG_SRC());
            Card_May_02.setImageResource(PLayer01_ListCard.get(1).getIMG_SRC());
            Card_May_03.setImageResource(PLayer01_ListCard.get(2).getIMG_SRC());

            Card_Nguoi_01.setImageResource(PLayer02_ListCard.get(0).getIMG_SRC());
            Card_Nguoi_02.setImageResource(PLayer02_ListCard.get(1).getIMG_SRC());
            Card_Nguoi_03.setImageResource(PLayer02_ListCard.get(2).getIMG_SRC());
        }
    }
}
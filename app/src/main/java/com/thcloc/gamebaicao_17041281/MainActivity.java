package com.thcloc.gamebaicao_17041281;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.bluetooth.BluetoothHidDeviceAppQosSettings;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int ManChoi_So = 0;

    ArrayList<Card> ListPlayingCard = new ArrayList<>();
    ArrayList<Integer> List_Index_Card = new ArrayList<>();
    ArrayList<KetQuaChoi> List_KetQuaChoi = new ArrayList<>();

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
    Button btnCheDoChoi;
    Button btnXemBangDiem;

    ImageView Card_Player01_01;
    ImageView Card_Player01_02;
    ImageView Card_Player01_03;
    ImageView Card_Player02_01;
    ImageView Card_Player02_02;
    ImageView Card_Player02_03;

    TextView txtTen_Player01;
    TextView txtTen_Player02;
    TextView txtDiem_Player01;
    TextView txtDiem_Player02;

    ArrayList<Card> PLayer01_ListCard;
    ArrayList<Card> PLayer02_ListCard;

    TextView logo_winner_player01;
    TextView logo_winner_player02;
    TextView logo_draw_player01;
    TextView logo_draw_player02;
    TextView logo_close_player01;
    TextView logo_close_player02;

    ListView lvwBangDiem;

    RadioButton rbtn_Nguoi_May;
    RadioButton rbtn_Nguoi_Nguoi;
    RadioButton rbtn_May_May;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PLayer01_ListCard = new ArrayList<>();
        PLayer02_ListCard = new ArrayList<>();

        Init_Data();
        btnChiaBai_Click();
        btnCheDoChoi_Click();
        btnXemBangDiem_Click();

        Card_Player01_01_Click();
        Card_Player01_02_Click();
        Card_Player01_03_Click();
        Card_Player02_01_Click();
        Card_Player02_02_Click();
        Card_Player02_03_Click();

        //Khoá Chức Năng Sau, Khi Lần Đầu Vào Game
        btnXemBangDiem.setEnabled(false);
    }

    protected void Init_Data() {
        Init_PlayingCard();

        btnCheDoChoi = (Button) findViewById(R.id.btnCheDoiChoi);
        btnChiaBai = (Button) findViewById(R.id.btnChiaBai);
        btnXemBangDiem = (Button) findViewById(R.id.btnXemBangDiem);

        Card_Player01_01 = (ImageView) findViewById(R.id.card_player01_01);
        Card_Player01_02 = (ImageView) findViewById(R.id.card_player01_02);
        Card_Player01_03 = (ImageView) findViewById(R.id.card_player01_03);

        Card_Player02_01 = (ImageView) findViewById(R.id.card_player02_01);
        Card_Player02_02 = (ImageView) findViewById(R.id.card_player02_02);
        Card_Player02_03 = (ImageView) findViewById(R.id.card_player02_03);

        txtTen_Player01 = (TextView) findViewById(R.id.txtTen_Player01);
        txtTen_Player02 = (TextView) findViewById(R.id.txtTen_Player02);
        txtDiem_Player01 = (TextView) findViewById(R.id.txtDiem_Player01);
        txtDiem_Player02 = (TextView) findViewById(R.id.txtDiem_Player02);

        logo_winner_player01 = (TextView) findViewById(R.id.logo_winner_player01);
        logo_winner_player02 = (TextView) findViewById(R.id.logo_winner_player02);

        logo_draw_player01 = (TextView) findViewById(R.id.logo_draw_player01);
        logo_draw_player02 = (TextView) findViewById(R.id.logo_draw_player02);

        logo_close_player01 = (TextView) findViewById(R.id.logo_close_player01);
        logo_close_player02 = (TextView) findViewById(R.id.logo_close_player02);

        Control_Card_ON_OFF(false, false);
    }

    //Khởi Tạo Danh Sách Bộ Bài
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

    //Click Chia Bài
    protected void btnChiaBai_Click() {
        btnChiaBai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChiaBai == false) {
                    //Bắt Đầu Chia Bài
                    //ChiaBai();
                    ChiaBai_02();

                    //Config Background Thẻ Bài
                    Card_Player01_01.setImageResource(R.drawable.background);
                    Card_Player01_02.setImageResource(R.drawable.background);
                    Card_Player01_03.setImageResource(R.drawable.background);

                    Card_Player02_01.setImageResource(R.drawable.background);
                    Card_Player02_02.setImageResource(R.drawable.background);
                    Card_Player02_03.setImageResource(R.drawable.background);

                    //Config Chế Độ Chơi
                    if (CheDoChoi == 0) {
                        Control_Card_ON_OFF(false, true);
                    }
                    if (CheDoChoi == 1) {
                        Control_Card_ON_OFF(true, true);
                    }
                    if (CheDoChoi == 2) {
                        Control_Card_ON_OFF(false, false);
                        Show_Player_EndGame(CheDoChoi, WhoIsWinner(CheDoChoi));
                    }

                    isChiaBai = true;
                    btnChiaBai.setText("Ván Mới");

                    //Ẩn Nút Chế Độ Chơi
                    btnCheDoChoi.setVisibility(View.GONE);

                    //Ẩn Nút Xem Bảng Điểm
                    btnXemBangDiem.setVisibility(View.GONE);

                    //Mở Khoá Chức Năng Sau, Khi Đã Vào Game
                    btnXemBangDiem.setEnabled(true);
                } else {
                    //Reset Ván Mới
                    //------------------------------------------------------------
                    //Reset Background
                    Card_Player01_01.setImageResource(android.R.color.transparent);
                    Card_Player01_02.setImageResource(android.R.color.transparent);
                    Card_Player01_03.setImageResource(android.R.color.transparent);

                    Card_Player02_01.setImageResource(android.R.color.transparent);
                    Card_Player02_02.setImageResource(android.R.color.transparent);
                    Card_Player02_03.setImageResource(android.R.color.transparent);
                    //------------------------------------------------------------

                    //Reset Giá Trị Liên Quan
                    isChiaBai = false;
                    btnChiaBai.setText("Chia");
                    isDone_MoBai = 0;
                    List_Index_Card.clear();
                    PLayer01_ListCard.clear();
                    PLayer02_ListCard.clear();
                    Control_Card_ON_OFF(false, false);

                    //Hiện Nút Chế Độ Chơi
                    btnCheDoChoi.setVisibility(View.VISIBLE);
                    //Hiện Nút Xem Bảng Điểm
                    btnXemBangDiem.setVisibility(View.VISIBLE);

                    //Ẩn Các Logo Thông Báo End Game
                    logo_winner_player01.setVisibility(View.GONE);
                    logo_winner_player02.setVisibility(View.GONE);
                    logo_close_player01.setVisibility(View.GONE);
                    logo_close_player02.setVisibility(View.GONE);
                    logo_draw_player01.setVisibility(View.GONE);
                    logo_draw_player02.setVisibility(View.GONE);
                }
            }
        });
    }

    //Click Đổi Chế Độ Chơi
    protected void btnCheDoChoi_Click() {
        btnCheDoChoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayMetrics metrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(metrics);

                int height = metrics.heightPixels;
                int width = metrics.widthPixels;

                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.layout_che_do_choi);
                dialog.setCanceledOnTouchOutside(false);
                dialog.getWindow().setLayout((width * 5) / 6, (height * 2) / 4);//<---Set Kích Thước
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//<---Ẩn Background Dialog

                rbtn_Nguoi_May = (RadioButton) dialog.findViewById(R.id.rbtn_Nguoi_May);
                rbtn_Nguoi_Nguoi = (RadioButton) dialog.findViewById(R.id.rbtn_Nguoi_Nguoi);
                rbtn_May_May = (RadioButton) dialog.findViewById(R.id.rbtn_May_May);

                Button btnThucHienCheDoChoi = (Button) dialog.findViewById(R.id.btnDoiCheDoChoi);
                Button btnHuy_CheDoiChoi = (Button) dialog.findViewById(R.id.btnHuyThucHien_CheDoChoi);

                if (CheDoChoi == 0) {
                    rbtn_Nguoi_May.setChecked(true);
                }
                if (CheDoChoi == 1) {
                    rbtn_Nguoi_Nguoi.setChecked(true);
                }
                if (CheDoChoi == 2) {
                    rbtn_May_May.setChecked(true);
                }

                btnThucHienCheDoChoi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (rbtn_Nguoi_May.isChecked()) {
                            CheDoChoi = 0;
                        }
                        if (rbtn_Nguoi_Nguoi.isChecked()) {
                            CheDoChoi = 1;
                        }
                        if (rbtn_May_May.isChecked()) {
                            CheDoChoi = 2;
                        }

                        Update_CheDoiChoi(CheDoChoi);
                        dialog.cancel();
                    }
                });

                btnHuy_CheDoiChoi.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
    }

    //Click Xem Bảng Điểm
    protected void btnXemBangDiem_Click() {
        btnXemBangDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.layout_bang_diem);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//<---Ẩn Background Dialog

                Button btnThoatBangDiem = (Button) dialog.findViewById(R.id.btnThoatBangDiem);
                lvwBangDiem = (ListView) dialog.findViewById(R.id.lvwBangDiem);

                Custom_Adapter_BangDiem adapter = new Custom_Adapter_BangDiem(MainActivity.this, List_KetQuaChoi, R.layout.row_item_bang_diem);
                lvwBangDiem.setAdapter((ListAdapter) adapter);

                btnThoatBangDiem.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });

                dialog.show();
            }
        });
    }

    //Click Mở Bài 01_Player01
    protected void Card_Player01_01_Click() {
        Card_Player01_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDone_MoBai += 1;
                Card_Player01_01.setEnabled(false);
                Card_Player01_01.setImageResource(PLayer01_ListCard.get(0).getIMG_SRC());//<----Hiển Thị Lá Bài

                //Chế Độ Chơi Người vs Người
                if (CheDoChoi == 1 && isDone_MoBai == 6) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }
            }
        });
    }

    //Click Mở Bài 02_Player01
    protected void Card_Player01_02_Click() {
        Card_Player01_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDone_MoBai += 1;
                Card_Player01_02.setEnabled(false);
                Card_Player01_02.setImageResource(PLayer01_ListCard.get(1).getIMG_SRC());//<----Hiển Thị Lá Bài

                //Chế Độ Chơi Người vs Người
                if (CheDoChoi == 1 && isDone_MoBai == 6) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }
            }
        });
    }

    //Click Mở Bài 03_Player01
    protected void Card_Player01_03_Click() {
        Card_Player01_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDone_MoBai += 1;
                Card_Player01_03.setEnabled(false);
                Card_Player01_03.setImageResource(PLayer01_ListCard.get(2).getIMG_SRC());//<----Hiển Thị Lá Bài

                //Chế Độ Chơi Người vs Người
                if (CheDoChoi == 1 && isDone_MoBai == 6) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }
            }
        });
    }

    //Click Mở Bài 01_Player02
    protected void Card_Player02_01_Click() {
        Card_Player02_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDone_MoBai += 1;
                Card_Player02_01.setEnabled(false);
                Card_Player02_01.setImageResource(PLayer02_ListCard.get(0).getIMG_SRC());//<----Hiển Thị Lá Bài

                //Chế Độ Chơi Người vs Máy
                if (CheDoChoi == 0 && isDone_MoBai == 3) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }

                //Chế Độ Chơi Người vs Người
                if (CheDoChoi == 1 && isDone_MoBai == 6) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }
            }
        });
    }

    //Click Mở Bài 02_Player02
    protected void Card_Player02_02_Click() {
        Card_Player02_02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDone_MoBai += 1;
                Card_Player02_02.setEnabled(false);
                Card_Player02_02.setImageResource(PLayer02_ListCard.get(1).getIMG_SRC());//<----Hiển Thị Lá Bài

                //Chế Độ Chơi Người vs Máy
                if (CheDoChoi == 0 && isDone_MoBai == 3) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }

                //Chế Độ Chơi Người vs Người
                if (CheDoChoi == 1 && isDone_MoBai == 6) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }
            }
        });
    }

    //Click Mở Bài 03_Player03
    protected void Card_Player02_03_Click() {
        Card_Player02_03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isDone_MoBai += 1;
                Card_Player02_03.setEnabled(false);
                Card_Player02_03.setImageResource(PLayer02_ListCard.get(2).getIMG_SRC());//<----Hiển Thị Lá Bài

                //Chế Độ Chơi Người vs Máy
                if (CheDoChoi == 0 && isDone_MoBai == 3) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }

                //Chế Độ Chơi Người vs Người
                if (CheDoChoi == 1 && isDone_MoBai == 6) {
                    //Khi Mở Bài Hoàn Tất
                    if (WhoIsWinner(CheDoChoi) == 0) {
                        Show_Player_EndGame(CheDoChoi, 0);
                    }
                    if (WhoIsWinner(CheDoChoi) == 1) {
                        Show_Player_EndGame(CheDoChoi, 1);
                    }
                    if (WhoIsWinner(CheDoChoi) == 2) {
                        Show_Player_EndGame(CheDoChoi, 2);
                    }
                }
            }
        });
    }

    //Control ON_OFF Card
    protected void Control_Card_ON_OFF(boolean key_player01, boolean key_player02) {
        Card_Player01_01.setEnabled(key_player01);
        Card_Player01_02.setEnabled(key_player01);
        Card_Player01_03.setEnabled(key_player01);

        Card_Player02_01.setEnabled(key_player02);
        Card_Player02_02.setEnabled(key_player02);
        Card_Player02_03.setEnabled(key_player02);
    }

    //Get Số Ngẫu Nhiên
    protected int BAI_NGAU_NHIEN() {
        Random random = new Random();
        return random.nextInt(51);
    }

    //Xử Lý Chia Bài Cách 1
    protected void ChiaBai() {
        int temp_01, temp_02;

        for (int i = 0; i < 3; i++) {
            if (PLayer01_ListCard.size() > 0 && PLayer02_ListCard.size() > 0) {
                temp_01 = BAI_NGAU_NHIEN();
                temp_02 = BAI_NGAU_NHIEN();

                //------>PLayer 01

                //Kiểm Tra Bài Player 01
                if (PLayer01_ListCard.get(0).equals(ListPlayingCard.get(temp_01))) {
                    ChiaBai();
                }
                if (PLayer01_ListCard.size() > 1 && PLayer02_ListCard.size() > 1) {
                    if (PLayer01_ListCard.get(1).equals(ListPlayingCard.get(temp_01))) {
                        ChiaBai();
                    }
                }

                //Kiểm Tra Bài Player 02
                if (PLayer02_ListCard.get(0).equals(ListPlayingCard.get(temp_01))) {
                    ChiaBai();
                }
                if (PLayer01_ListCard.size() > 1 && PLayer02_ListCard.size() > 1) {
                    if (PLayer02_ListCard.get(1).equals(ListPlayingCard.get(temp_01))) {
                        ChiaBai();
                    }
                }

                //Đảm Bảo Tạo Đúng 3 Lá Bài
                if (PLayer01_ListCard.size() != 3) {
                    PLayer01_ListCard.add(ListPlayingCard.get(temp_01));
                }


                //------>PLayer 02

                //Kiểm Tra Bài Player 01
                if (PLayer01_ListCard.get(0).equals(ListPlayingCard.get(temp_02))) {
                    ChiaBai();
                }
                if (PLayer01_ListCard.size() > 1 && PLayer02_ListCard.size() > 1) {
                    if (PLayer01_ListCard.get(1).equals(ListPlayingCard.get(temp_02))) {
                        ChiaBai();
                    }
                }

                //Kiểm Tra Bài Player 02
                if (PLayer02_ListCard.get(0).equals(ListPlayingCard.get(temp_02))) {
                    ChiaBai();
                }
                if (PLayer01_ListCard.size() > 1 && PLayer02_ListCard.size() > 1) {
                    if (PLayer02_ListCard.get(1).equals(ListPlayingCard.get(temp_02))) {
                        ChiaBai();
                    }
                }

                //Đảm Bảo Tạo Đúng 3 Lá Bài
                if (PLayer02_ListCard.size() != 3) {
                    PLayer02_ListCard.add(ListPlayingCard.get(temp_02));
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

    //Xử Lý Chia Bài Cách 2
    protected void ChiaBai_02() {
        int temp = BAI_NGAU_NHIEN();

        if (List_Index_Card.size() == 0) {
            List_Index_Card.add(temp);
            ChiaBai_02();
        }

        if (List_Index_Card.size() > 0) {
            while (List_Index_Card.size() < 6) {
                boolean Check_IsHave = false;
                temp = BAI_NGAU_NHIEN();

                for (int i = 0; i < List_Index_Card.size(); i++) {
                    if (List_Index_Card.get(i) == temp) {
                        Check_IsHave = true;
                        break;
                    }
                }

                if (Check_IsHave == false) {
                    List_Index_Card.add(temp);
                }
            }
        }

        if (List_Index_Card.size() == 6) {
            PLayer01_ListCard.add(ListPlayingCard.get(List_Index_Card.get(0)));
            PLayer02_ListCard.add(ListPlayingCard.get(List_Index_Card.get(1)));
            PLayer01_ListCard.add(ListPlayingCard.get(List_Index_Card.get(2)));
            PLayer02_ListCard.add(ListPlayingCard.get(List_Index_Card.get(3)));
            PLayer01_ListCard.add(ListPlayingCard.get(List_Index_Card.get(4)));
            PLayer02_ListCard.add(ListPlayingCard.get(List_Index_Card.get(5)));
        }
    }

    //Get Người Chiến Thắng
    protected int WhoIsWinner(int CheDoChoi) {
        //Chế độ chơi Người vs Máy
        if (CheDoChoi == 0 && isDone_MoBai == 3) {
            return XuLyTinhHuongChoi();
        }

        //Chế độ chơi Người vs Người
        if (CheDoChoi == 1 && isDone_MoBai == 6) {
            return XuLyTinhHuongChoi();
        }

        //Chế độ chơi Người vs Máy
        if (CheDoChoi == 2) {
            return XuLyTinhHuongChoi();
        }

        return -1;
    }

    //Get Điểm
    protected int ConvertStringValue_toInteger(String Card_Value) {
        switch (Card_Value) {
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
                return 11;
            case "q":
                return 12;
            case "k":
                return 13;
        }

        return -1;
    }

    //Xử Lý Tính Giá Trị Thẻ Bài
    //Trả Về
    //1---Nếu Như Player 01 Win
    //2---Nếu Như Player 02 Win
    //0---Nếu Như Hoà
    //-1---Có Lỗi Xảy Ra
    protected int XuLyTinhHuongChoi() {
        int Value_Player01 = 0;
        int Value_Player02 = 0;

        //Check Player 01 Có 3 Lá Bài Tây Không ?
        if (Check_3_La_Bai_Tay(PLayer01_ListCard)) {
            Value_Player01 = Integer.MAX_VALUE;
        }

        //Check Player 02 Có 3 Lá Bài Tây Không ?
        if (Check_3_La_Bai_Tay(PLayer02_ListCard)) {
            Value_Player02 = Integer.MAX_VALUE;
        }

        //Trường Hợp Cả 2 Player Đều Có 3 Lá Bài Tây
        if (Value_Player01 == Integer.MAX_VALUE && Value_Player02 == Integer.MAX_VALUE) {
            return 0;
        }

        //Trường Hợp Player 01 Win (3 Lá Tây), Player 02 != 3 Lá Tây
        if (Value_Player01 == Integer.MAX_VALUE && Value_Player02 != Integer.MAX_VALUE) {
            return 1;
        }

        //Trường Hợp Player 02 Win (3 Lá Tây), Player 01 != 3 Lá Tây
        if (Value_Player01 != Integer.MAX_VALUE && Value_Player02 == Integer.MAX_VALUE) {
            return 2;
        }

        //------------------------------------------------------------------------------
        //Trường Hợp Còn Lại
        //------------------------------------------------------------------------------

        //Lấy Những Giá Trị Không Phải Là Bài Tây Ở Player 01
        if (!CheckBaiTay(PLayer01_ListCard.get(0))) {
            Value_Player01 += ConvertStringValue_toInteger(PLayer01_ListCard.get(0).getValue());
        }
        if (!CheckBaiTay(PLayer01_ListCard.get(1))) {
            Value_Player01 += ConvertStringValue_toInteger(PLayer01_ListCard.get(1).getValue());
        }
        if (!CheckBaiTay(PLayer01_ListCard.get(2))) {
            Value_Player01 += ConvertStringValue_toInteger(PLayer01_ListCard.get(2).getValue());
        }

        //Lấy Những Giá Trị Không Phải Là Bài Tây Ở Player 02
        if (!CheckBaiTay(PLayer02_ListCard.get(0))) {
            Value_Player02 += ConvertStringValue_toInteger(PLayer02_ListCard.get(0).getValue());
        }
        if (!CheckBaiTay(PLayer02_ListCard.get(1))) {
            Value_Player02 += ConvertStringValue_toInteger(PLayer02_ListCard.get(1).getValue());
        }
        if (!CheckBaiTay(PLayer02_ListCard.get(2))) {
            Value_Player02 += ConvertStringValue_toInteger(PLayer02_ListCard.get(2).getValue());
        }

        //Lấy Giá Trị Cuối
        String temp = Integer.toString(Value_Player01);
        Value_Player01 = Integer.parseInt(Character.toString(temp.charAt(temp.length() - 1)));
        temp = Integer.toString(Value_Player02);
        Value_Player02 = Integer.parseInt(Character.toString(temp.charAt(temp.length() - 1)));

        //Player 01 Thắng
        if (Value_Player01 > Value_Player02) {
            return 1;
        }

        //Player 02 Thắng
        if (Value_Player01 < Value_Player02) {
            return 2;
        }

        //Player 01 Thắng
        if (Value_Player01 == Value_Player02) {
            return 0;
        }

        return -1;
    }

    //Check Lá Bài Đó Có Phải Là Bài Tây
    protected boolean CheckBaiTay(Card card) {
        if (ConvertStringValue_toInteger(card.getValue()) == 11) {
            return true;
        }
        if (ConvertStringValue_toInteger(card.getValue()) == 12) {
            return true;
        }
        if (ConvertStringValue_toInteger(card.getValue()) == 13) {
            return true;
        }

        return false;
    }

    //Check Có Phải Có 3 Lá Bài Tây
    protected boolean Check_3_La_Bai_Tay(ArrayList<Card> dsCard) {
        if (CheckBaiTay(dsCard.get(0)) && CheckBaiTay(dsCard.get(1))) {
            if (CheckBaiTay(dsCard.get(2))) {
                return true;
            }
        }

        return false;
    }

    //Show Infor Khi Kết Thúc Game
    protected void Show_Player_EndGame(int CheDoChoi, int winner) {
        ManChoi_So += 1;//<--Đến Số Ván Chơi

        //Chế Độ Chơi Người vs Máy
        if (CheDoChoi == 0) {
            Card_Player01_01.setImageResource(PLayer01_ListCard.get(0).getIMG_SRC());
            Card_Player01_02.setImageResource(PLayer01_ListCard.get(1).getIMG_SRC());
            Card_Player01_03.setImageResource(PLayer01_ListCard.get(2).getIMG_SRC());

            //Player 02 Winner
            if (winner == 2) {
                Diem_Player02 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                logo_winner_player02.setVisibility(View.VISIBLE);
                logo_close_player01.setVisibility(View.VISIBLE);
            }

            //Player 01 Winner
            if (winner == 1) {
                Diem_Player01 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                logo_winner_player01.setVisibility(View.VISIBLE);
                logo_close_player02.setVisibility(View.VISIBLE);
            }

            //Hoà Nhau
            if (winner == 0) {
                logo_draw_player01.setVisibility(View.VISIBLE);
                logo_draw_player02.setVisibility(View.VISIBLE);
            }
        }

        //Chế Độ Chơi Người vs Người
        if (CheDoChoi == 1) {
            //Player 02 Winner
            if (winner == 2) {
                Diem_Player02 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                logo_winner_player02.setVisibility(View.VISIBLE);
                logo_close_player01.setVisibility(View.VISIBLE);
            }

            //Player 01 Winner
            if (winner == 1) {
                Diem_Player01 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                logo_winner_player01.setVisibility(View.VISIBLE);
                logo_close_player02.setVisibility(View.VISIBLE);
            }

            //Hoà Nhau
            if (winner == 0) {
                logo_draw_player01.setVisibility(View.VISIBLE);
                logo_draw_player02.setVisibility(View.VISIBLE);
            }
        }

        //Chế Độ Chơi Máy vs Máy
        if (CheDoChoi == 2) {
            Card_Player01_01.setImageResource(PLayer01_ListCard.get(0).getIMG_SRC());
            Card_Player01_02.setImageResource(PLayer01_ListCard.get(1).getIMG_SRC());
            Card_Player01_03.setImageResource(PLayer01_ListCard.get(2).getIMG_SRC());
            Card_Player02_01.setImageResource(PLayer02_ListCard.get(0).getIMG_SRC());
            Card_Player02_02.setImageResource(PLayer02_ListCard.get(1).getIMG_SRC());
            Card_Player02_03.setImageResource(PLayer02_ListCard.get(2).getIMG_SRC());

            //Player 02 Winner
            if (winner == 2) {
                Diem_Player02 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                logo_winner_player02.setVisibility(View.VISIBLE);
                logo_close_player01.setVisibility(View.VISIBLE);
            }

            //Player 01 Winner
            if (winner == 1) {
                Diem_Player01 += 1;
                txtDiem_Player01.setText(Integer.toString(Diem_Player01));
                txtDiem_Player02.setText(Integer.toString(Diem_Player02));
                logo_winner_player01.setVisibility(View.VISIBLE);
                logo_close_player02.setVisibility(View.VISIBLE);
            }

            //Hoà Nhau
            if (winner == 0) {
                logo_draw_player01.setVisibility(View.VISIBLE);
                logo_draw_player02.setVisibility(View.VISIBLE);
            }
        }

        Luu_Ket_Qua_Choi(Diem_Player01, Diem_Player02, winner);
    }

    //Lưu Kết Quả Chơi
    protected void Luu_Ket_Qua_Choi(int Diem_Player01, int Diem_Player02, int Winner){
        KetQuaChoi kqc = new KetQuaChoi(ManChoi_So, txtTen_Player01.getText().toString(), txtTen_Player02.getText().toString(), Diem_Player01, Diem_Player02, Winner);
        List_KetQuaChoi.add(kqc);
    }
    //Cập Nhật Lại Giao Diện Phù Hợp Với Chế Độ Chơi
    protected void Update_CheDoiChoi(int CheDoChoi) {
        ManChoi_So = 0;

        if (CheDoChoi == 0) {
            txtTen_Player01.setText("Máy");
            txtTen_Player02.setText("Người Chơi");
            txtDiem_Player01.setText("0");
            txtDiem_Player02.setText("0");
            Diem_Player01 = 0;
            Diem_Player02 = 0;
            List_KetQuaChoi.clear();
            return;
        }
        if (CheDoChoi == 1) {
            txtTen_Player01.setText("Người Chơi 01");
            txtTen_Player02.setText("Người Chơi 02");
            txtDiem_Player01.setText("0");
            txtDiem_Player02.setText("0");
            Diem_Player01 = 0;
            Diem_Player02 = 0;
            List_KetQuaChoi.clear();
            return;
        }
        if (CheDoChoi == 2) {
            txtTen_Player01.setText("Máy 01");
            txtTen_Player02.setText("Máy 02");
            txtDiem_Player01.setText("0");
            txtDiem_Player02.setText("0");
            Diem_Player01 = 0;
            Diem_Player02 = 0;
            List_KetQuaChoi.clear();
            return;
        }
    }
}
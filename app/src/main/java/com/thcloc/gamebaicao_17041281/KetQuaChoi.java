package com.thcloc.gamebaicao_17041281;

public class KetQuaChoi {
    private int Game_Index;
    private String Name_Player01;
    private String Name_Player02;
    private int Score_Player01;
    private int Score_Player02;
    private int Winner;

    public KetQuaChoi(int game_Index, String name_Player01, String name_Player02, int score_Player01, int score_Player02, int winner) {
        Game_Index = game_Index;
        Name_Player01 = name_Player01;
        Name_Player02 = name_Player02;
        Score_Player01 = score_Player01;
        Score_Player02 = score_Player02;
        Winner = winner;
    }

    public int getScore_Player01() {
        return Score_Player01;
    }

    public void setScore_Player01(int score_Player01) {
        Score_Player01 = score_Player01;
    }

    public int getScore_Player02() {
        return Score_Player02;
    }

    public void setScore_Player02(int score_Player02) {
        Score_Player02 = score_Player02;
    }

    public String getName_Player01() {
        return Name_Player01;
    }

    public void setName_Player01(String name_Player01) {
        Name_Player01 = name_Player01;
    }

    public String getName_Player02() {
        return Name_Player02;
    }

    public void setName_Player02(String name_Player02) {
        Name_Player02 = name_Player02;
    }

    public int getGame_Index() {
        return Game_Index;
    }

    public void setGame_Index(int game_Index) {
        Game_Index = game_Index;
    }

    public int getWinner() {
        return Winner;
    }

    public void setWinner(int winner) {
        Winner = winner;
    }
}

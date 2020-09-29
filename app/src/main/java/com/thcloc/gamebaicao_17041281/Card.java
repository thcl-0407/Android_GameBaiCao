package com.thcloc.gamebaicao_17041281;

import java.util.Objects;

public class Card {
    private String Value;
    private String Category;
    private int IMG_SRC;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return IMG_SRC == card.IMG_SRC;
    }

    @Override
    public int hashCode() {
        return Objects.hash(IMG_SRC);
    }

    public Card(String value, String category, int IMG_SRC) {
        Value = value;
        Category = category;
        this.IMG_SRC = IMG_SRC;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getIMG_SRC() {
        return IMG_SRC;
    }

    public void setIMG_SRC(int IMG_SRC) {
        this.IMG_SRC = IMG_SRC;
    }
}

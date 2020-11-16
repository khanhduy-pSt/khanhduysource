package com.example.junoshop.Model;

public class Drawermenu {
    public Drawermenu(String text_optionmenu, int img_optionmenu) {
        this.text_optionmenu = text_optionmenu;
        this.img_optionmenu = img_optionmenu;
    }
    public String text_optionmenu;

    public String getText_optionmenu() {
        return text_optionmenu;
    }

    public void setText_optionmenu(String text_optionmenu) {
        this.text_optionmenu = text_optionmenu;
    }

    public int getImg_optionmenu() {
        return img_optionmenu;
    }

    public void setImg_optionmenu(int img_optionmenu) {
        this.img_optionmenu = img_optionmenu;
    }
    public int img_optionmenu;

}

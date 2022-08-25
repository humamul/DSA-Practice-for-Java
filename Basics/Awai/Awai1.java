package Awai;

import javafx.scene.shape.SVGPath;

import java.util.Locale;
import java.util.Scanner;

enum Stadium{

    EDEN_GARDENS_STADIUM("1"),WANKHEDE_STADIUM("2"), CHIDAMBARAM_STADIUM("3"),M_CHINNASWAMY_STADIUM("4");
    private String history;

    public String getInfo(){
        return this.history;

    }
    Stadium(String h){
        this.history = h;
    }
}
class IPL{
   static public void homeStadium(Stadium s){
        System.out.println(s.getInfo());
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Stadium str = Stadium.valueOf(s.next());
        homeStadium(str);
        Stadium[] arr = Stadium.values();
    }
}
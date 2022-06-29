package com.javarush.games.minigames.mini03;

import com.javarush.engine.cell.Game;
import com.javarush.engine.cell.Color;
import javafx.application.Application;

/* 
Простая программа
*/

public class SymbolGame extends Game {
    private String valueStr = "JAVARUSH";
    @Override
    public void initialize() {
        //
        setScreenSize(8, 3);
        setScore(2500);

//        for (int i = 0; i < 8; i++) {
//            setCellValueEx(i, 1, Color.ORANGE, valueStr);
//        }
        setCellValueEx(0, 1, Color.ORANGE, "J");
        setCellValueEx(1, 1, Color.ORANGE, "A");
        setCellValueEx(2, 1, Color.ORANGE, "V");
        setCellValueEx(3, 1, Color.ORANGE, "A");
        setCellValueEx(4, 1, Color.ORANGE, "R");
        setCellValueEx(5, 1, Color.ORANGE, "U");
        setCellValueEx(6, 1, Color.ORANGE, "S");
        setCellValueEx(7, 1, Color.ORANGE, "H");

    }
    //напишите тут ваш код
}

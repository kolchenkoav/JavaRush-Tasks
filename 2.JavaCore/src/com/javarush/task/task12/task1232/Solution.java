package com.javarush.task.task12.task1232;

/* 
Нужно добавить в программу новую функциональность
*/

public class Solution {
    public static void main(String[] args) {

        Pegasus horse = new Pegasus();
        horse.run();
    }

    public static interface CanFly {
        public void fly();
    }

    public static class Horse {
        public void run() {

        }
    }

    public static class Pegasus extends Horse implements CanFly {
        public void fly() {

        }
    }
}

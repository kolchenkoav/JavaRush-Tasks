package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //System.out.print("Введите первое положительное число :");
        int x = Integer.parseInt(reader.readLine());
        //System.out.println("");

        //System.out.print("Введите второе положительное число :");
        int y = Integer.parseInt(reader.readLine());
        //System.out.println("");


        int nod = gcdByEuclidsAlgorithm(x, y);
        System.out.println(nod);

    }
    private static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

}

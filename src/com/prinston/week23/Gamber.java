package com.prinston.week23;

/**
 * @author Baurzhan Alzhanov
 * @date on 27.07.2021
 */


public class Gamber {
    public static void main(String[] args) {
        int stake = Integer.parseInt(args[0]);
        int goal = Integer.parseInt(args[1]);
        int trials = Integer.parseInt(args[2]);
        int bets =0, wins = 0;
        for (int i = 0; i < trials; i++) {
            int cash = stake;
            while(cash > 0 && cash < goal){
                bets++;
                if(Math.random() <0.5) cash++;
                else cash--;
            }
            if (cash == goal) wins++;

        }
        System.out.println(100*wins/trials + " % wins");
        System.out.println("Avg # bets: " + bets/trials);

    }
}

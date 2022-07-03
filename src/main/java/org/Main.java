package org;

public class Main {
    public static void main(String[] args) {

        Player player = new Player("Fabian");

        player.roll(5);
        System.out.println(player.getCurrentScore());
    }
}
package org;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Player player = new Player("Max");

        game.addPlayer(player);

        game.start();

        game.roll(4);
        game.roll(4);

        game.roll(6);
        game.roll(4);

        game.roll(4);
        game.roll(4);

        game.roll(10);

        game.roll(4);
        game.roll(4);

        game.roll(10);

        game.roll(5);
        game.roll(5);

        game.roll(8);
        game.roll(1);

        game.roll(10);

        game.roll(3);
        game.roll(4);

        System.out.println(player.getName() + ": " + player.getScoreUntilFrame(10));
    }
}
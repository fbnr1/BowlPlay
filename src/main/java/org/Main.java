package org;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        Player player = new Player("Max");
        Player player2 = new Player("Tom");

        game.addPlayer(player);
        game.addPlayer(player2);

        game.start();

        // player1
        game.roll(10);


        // player2
        game.roll(10);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(3);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(3);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(3);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(3);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(3);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(3);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(3);

        // player1
        game.roll(2);
        game.roll(3);

        // player2
        game.roll(2);
        game.roll(4);

        game.roll(2);
        game.roll(8);

        game.roll(2);

        game.roll(10);

        game.roll(3);

        System.out.println(player.getName() + ": " + player.getCurrentScore());
        System.out.println(player2.getName() + ": " + player2.getCurrentScore());

    }
}
package hwr.oop;

public class Player {

    private int favorPins = 34;
    private String nameOfPlayer;
    private static int score = 0;

    public Player(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }

    public String getNameOfPlayer(String nameOfPlayer){
        return nameOfPlayer;
    }
    public static int countScore(int favorPins){
        score = score + favorPins;
        return score;
    }
}

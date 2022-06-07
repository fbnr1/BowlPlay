package hwr.oop;

public class Player {

    private int favorPins = 0;
    private String nameOfPlayer;
    private int score = 0;
    private int quantityOfPlayer = 0;

    public Player(String nameOfPlayer){
        this.nameOfPlayer = nameOfPlayer;
    }

    public String getNameOfPlayer(String nameOfPlayer){
        return nameOfPlayer;
    }
    public int countScore(int favorPins){
        score = score + favorPins;
        return score;
    }
}

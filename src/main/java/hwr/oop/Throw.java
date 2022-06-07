package hwr.oop;

public class Throw {
    static boolean lastThrowStrike = false;
    public Throw(){

    }
    public static boolean checkAllPinsFavor(int favorPins){
        if (favorPins == 10){
            return (lastThrowStrike = true);
        }
        return lastThrowStrike;
    }
}

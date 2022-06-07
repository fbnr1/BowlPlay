package hwr.oop;

public class Throw {
    static boolean lastThrowStrike = false;
    // static boolean FavorPinsAreValid = true;
    public Throw(){

    }

    public static int getFavorPins(int favorPins){
        return favorPins;
    }

    public static boolean checkAllPinsFavor(int favorPins){
        if (favorPins == 10){
            return true;
        }
        return lastThrowStrike;
    }

    public static boolean checkQuantityOfFavorPins(int favorPins){
        if (favorPins > 10){
            return false;
        }
        return true;
    }
}

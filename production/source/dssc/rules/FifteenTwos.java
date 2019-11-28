package dssc.rules;

import dssc.Hand;

import java.util.ArrayList;

public class FifteenTwos {
    public static final int FIFTEEN = 15;

    public static int checkFifteenTwos(ArrayList<Integer> values){
        ArrayList<Integer> values_changed = values;
        for(int i = 0; i < Hand.CARDS_NUMBER; i++){
            if(values_changed.get(i) > 10){
                values_changed.set(i, 10);
            }
        }
        int fifteens = count(values_changed, 0, 0);
        return fifteens *= 2;

    }
    private static int count(ArrayList<Integer> values, int i, int val) {
        if(i >= values.size()){
            return 0;
        }
        int fifteens = 0;
        fifteens += count(values, i + 1, val);
        val += values.get(i);
        if(val == 15){
            fifteens++;
        }
        fifteens += count(values, i + 1, val);
        return fifteens;
    }
}

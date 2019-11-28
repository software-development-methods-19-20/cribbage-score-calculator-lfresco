package dssc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static dssc.Hand.parseHand;

public class cribbageScore {

    public static final int FIFTEEN = 15;
    public static int checkPairs(ArrayList<Integer> values){
        int pairs = 0;
        int royalPairs = 0;
        int doublePairsRoyal = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < Hand.CARDS_NUMBER; i++){
            Integer count  = map.get(values.get(i));
            if(count == null){
                map.put(values.get(i), 1);
            } else {
                map.put(values.get(i), count + 1);
            }

        }

        for(Integer i : map.values()){
            if(i == 2)
                pairs ++;
            else if( i == 3)
                royalPairs ++;
            else if( i == 4)
                doublePairsRoyal++;
        }
        int result = pairs * 2 + royalPairs * 6 + doublePairsRoyal * 12;
        return result;
    }
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

    public static int score(String input) {

        Hand hand = parseHand(input);
        int result = 0;
        int pairs = checkPairs(hand.getValues());
        int flush = checkFlush(hand.getValues(), hand.getSeeds());
        int runs = checkRuns(hand.getValues());
        int fifteentwos = checkFifteenTwos(hand.getValues());

        result += pairs;
        result += runs;
        result += fifteentwos;
        result += flush;
        return result;
    }

    private static int checkRuns(ArrayList<Integer> values) {

        Collections.sort(values);

        int current_run = 1;

        for(int i = 0; i < values.size() - 1; i ++){
            int supposed_next = values.get(i) + 1;
            if(values.get(i + 1 ) == supposed_next){
                current_run ++;
            }
        }
        if(current_run == 3) {
            return 3;
        } else if (current_run == 4){
            return 4;
        } else if(current_run == 5){
            return 5;
        } else return 0;
    }

    private static int checkFlush(ArrayList<Integer> values, ArrayList<Character> seeds){

        int flush = 1;

        for(int i = 1; i < Hand.CARDS_NUMBER - 1; i++){
            if(seeds.get(i) == seeds.get(0)){
                flush++;
            }
        }
        if( (flush < 4)){
            flush = 0;
        } else {
            if(seeds.get(0) == seeds.get(4))
                flush++;
        }

        int jack_count = 0;
        Character starter_seed = seeds.get(4);
        for(int i = 0; i < Hand.CARDS_NUMBER - 1; i++){
            if((seeds.get(i) == starter_seed) && (values.get(i) == 11))
                jack_count++;
        }

        return flush + jack_count;


    }

}

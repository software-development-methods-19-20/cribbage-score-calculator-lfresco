package dssc;

import java.util.ArrayList;
import java.util.HashMap;

import static dssc.Hand.parseHand;

public class cribbageScore {

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

    public static int score(String input) {

        Hand hand = parseHand(input);
        int result = 0;
        int pairs = checkPairs(hand.getValues());

        result += pairs;
        return result;
    }
}

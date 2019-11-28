package dssc.rules;

import dssc.Hand;

import java.util.ArrayList;
import java.util.HashMap;

public class Pairs {
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
}

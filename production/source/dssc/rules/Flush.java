package dssc.rules;

import dssc.Hand;

import java.util.ArrayList;

public class Flush {

    private static int checkForSeeds(ArrayList<Character> seeds){
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

        return flush;
    }

    private static int checkForJacks(ArrayList<Integer> values, ArrayList<Character> seeds){

        int jack_count = 0;
        Character starter_seed = seeds.get(4);
        for(int i = 0; i < Hand.CARDS_NUMBER - 1; i++){
            if((seeds.get(i) == starter_seed) && (values.get(i) == 11))
                jack_count++;
        }
        return jack_count;
    }
    public static int checkFlush(ArrayList<Integer> values, ArrayList<Character> seeds){

        int flush = checkForSeeds(seeds);
        int jack_count = checkForJacks(values, seeds);


        return flush + jack_count;


    }
}

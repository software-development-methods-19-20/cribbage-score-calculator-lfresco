package dssc;

import java.util.ArrayList;
import java.util.List;


public class Hand {
    public static final int HANDSIZE = 9;
    public static final int CARDS_NUMBER = 5;

    private ArrayList<Character> seeds;
    private ArrayList<Integer> values;

    public Hand(ArrayList<Integer> values, ArrayList<Character> seeds){
        this.values = values;
        this.seeds = seeds;
    }
    public static Hand parseHand(String input){
        ArrayList<Integer> values = new ArrayList<>();
        ArrayList<Character> seeds = new ArrayList<>();

        for(int i = 0; i < HANDSIZE; i = i + 2){
            int value = Character.getNumericValue(input.charAt(i));
            char seed = input.charAt(i + 1);

            values.add(value);
            seeds.add(seed);
        }

        Hand hand = new Hand(values, seeds);
        return hand;
    }

    public ArrayList<Integer> getValues(){
        return this.values;
    }

    public ArrayList<Character> getSeeds() {
        return seeds;
    }
}

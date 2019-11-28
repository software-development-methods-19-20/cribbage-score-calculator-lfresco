package dssc;

import dssc.rules.Flush;
import dssc.rules.Pairs;
import dssc.rules.Runs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

import static dssc.Hand.parseHand;
import static dssc.rules.FifteenTwos.checkFifteenTwos;

public class cribbageScore {



    public static int score(String input) {

        Hand hand = parseHand(input);
        int result = 0;
        int pairs = Pairs.checkPairs(hand.getValues());
        int flush = Flush.checkFlush(hand.getValues(), hand.getSeeds());
        int runs = Runs.checkRuns(hand.getValues());
        int fifteentwos = checkFifteenTwos(hand.getValues());

        result += pairs;
        result += runs;
        result += fifteentwos;
        result += flush;
        return result;
    }




}

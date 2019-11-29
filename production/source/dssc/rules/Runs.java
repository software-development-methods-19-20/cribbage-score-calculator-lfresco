package dssc.rules;

import java.util.ArrayList;
import java.util.Collections;

public class Runs {

    private static int findRuns(ArrayList<Integer> values){
        Collections.sort(values);

        int current_run = 1;

        for(int i = 0; i < values.size() - 1; i ++){
            int supposed_next = values.get(i) + 1;
            if(values.get(i + 1 ) == supposed_next){
                current_run ++;
            }
        }
        return current_run;
    }

    private static int parseResult(int current_run){
        if(current_run == 3) {
            return 3;
        } else if (current_run == 4){
            return 4;
        } else if(current_run == 5){
            return 5;
        } else return 0;
    }

    public static int checkRuns(ArrayList<Integer> values) {
        return parseResult(findRuns(values));
    }


}

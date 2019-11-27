package test;

import dssc.cribbageScore;
import org.junit.jupiter.api.Test;
import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class cribbageTest {

    @Test
    void checkPairs(){
        assertThat(cribbageScore.score("5H5H8S6C7D"), is(2));

    }

    @Test
    void checkRoayalPairs(){
        assertThat(cribbageScore.score("5H5H5S6C7D"), is(6));
    }

    @Test
    void checkDoubleRoyalPairs(){
        assertThat(cribbageScore.score("5H5H5S5C7D"), is(12));
    }

    @Test
    void checkMixOfPairs(){
        assertThat(cribbageScore.score("5H5H5S6C6D"), is(8));
    }
}

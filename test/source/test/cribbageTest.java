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
        assertThat(cribbageScore.score("5H5H9S6CAD"), is(2));

    }

    @Test
    void checkRoayalPairs(){
        assertThat(cribbageScore.score("5H5H5S6C9D"), is(6));
    }

    @Test
    void checkDoubleRoyalPairs(){
        assertThat(cribbageScore.score("5H5H5S5C7D"), is(12));
    }

    @Test
    void checkMixOfPairs(){
        assertThat(cribbageScore.score("5H5H5S6C6D"), is(8));
    }

    @Test
    void runofThree(){
        assertThat(cribbageScore.score("1H2H3S5C7D"), is(3));
    }

    @Test
    void runofFour() { assertThat(cribbageScore.score("1H2H3S4C6D"), is(4));}

    @Test
    void runofFive() { assertThat(cribbageScore.score("1H2H3S4C5D"), is(5));}

    @Test
    void pairandrunofFour() {assertThat(cribbageScore.score("1H2H3S4C1D"), is(6));}

    @Test
    void checkLetters() {assertThat(cribbageScore.score("QHQHJSJC7D"), is( 4));}

    @Test
    void checkFlushofFour() {assertThat(cribbageScore.score("1H3H5H7H9D"), is(4));}

    @Test
    void chechkFlushofFive() {assertThat(cribbageScore.score("1H3H5H7H9H"), is(5));}

    @Test
    void checkFlushandJack() { assertThat(cribbageScore.score("AH3H6HJH9H"), is(5 + 1));}

    @Test
    void fifteenTwos() { assertThat(cribbageScore.score("0D1SH36D5H"), is(2));}

    @Test
    void finalTest() {
        assertThat(cribbageScore.score("5H5D5SJC5C"), is(29));
        assertThat(cribbageScore.score("0DJHQSAC9D"), is(4));
    }

}

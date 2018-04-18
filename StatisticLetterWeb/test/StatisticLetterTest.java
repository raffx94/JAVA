
import java.util.HashMap;

import org.junit.Test;
import static org.junit.Assert.*;
import model.LetterModel;
import model.WrongArgumentsException;

/**
 * Test model LetterModel.class
 *
 *
 * @author Rafał Miąsko
 * @version 2.0
 *
 *
 */
public class StatisticLetterTest {

    public StatisticLetterTest() {
    }

    /**
     *
     * test input data to the method HashMap
     */
    @Test
    public void testHashMap() {
        LetterModel testModel = new LetterModel();
        String data = "aaaaabbbbb";

        final HashMap<Character, Integer> newCounter = new HashMap<>();

        newCounter.put('a', 5);
        newCounter.put('b', 5);

        try {

            assertEquals("the variable should be the same", testModel.hashmap(data), newCounter);
            assertEquals("length this collections  should be the same", testModel.hashmap(data).size(), newCounter.size());

        } catch (WrongArgumentsException ex) {
        }
    }

    /**
     * test method HashMap if data is null
     */
    @Test
    public void testHashMapIfNull() {

        LetterModel testModel = new LetterModel();
        try {
            String data = null;
            testModel.hashmap(data);
            assert false : "method should be generate a excption";
        } catch (WrongArgumentsException ex) {

        }

    }

    /**
     * test HashMap if data is digit
     */
    @Test
    public void testHashMapIfDigitOrOther() {
        LetterModel testModelOne = new LetterModel();

        String data = "12345678sd.''.'..'.aaaaaaaaaaadddd";

        try {

            testModelOne.hashmap(data);

            assert false : "the method should be generate an exception";

        } catch (WrongArgumentsException ex) {

        }
    }

    /**
     * test method resultOfSum
     */
    @Test
    public void testResultOfSum() {
        LetterModel testModel = new LetterModel();

        int size = 10;
        double statisticA = (5 / size);
        double statisticB = (5 / size);
        double sumA = Math.abs(statisticA - 6.22);
        double sumB = Math.abs(statisticB - 1.18);
        Double sum = sumA + sumB;

        try {

            String dataFirst = "BB";

            testModel.hashmap(dataFirst);
            testModel.resultOfSum(dataFirst);

            if (sum.equals(testModel.getSumResult())) {
                assert false : " the variable should be different";

            }

            LetterModel testModelOne = new LetterModel();

            String Data = "AAAAAKKBBBBB";
            testModelOne.hashmap(Data);
            testModelOne.resultOfSum(Data);

            if (sum.equals(testModelOne.getSumResult())) {
                assert false : " the variable should be different";
            }

            LetterModel testModelTwo = new LetterModel();

            String dataTwo = "AAAAABBBBB";
            testModelTwo.hashmap(dataTwo);
            testModelTwo.resultOfSum(dataTwo);
            Double sumSecond = testModelTwo.getSumResult();

            assertEquals("the variable should be the same", sum, sumSecond);

            LetterModel testModelThird = new LetterModel();

            String dataThird = "1231414233131313133131313";

            testModelThird.hashmap(dataThird);
            testModelThird.resultOfSum(dataThird);
            assert false : " result of sum should be  generate an exception";

        } catch (WrongArgumentsException ex) {

        }

    }

}

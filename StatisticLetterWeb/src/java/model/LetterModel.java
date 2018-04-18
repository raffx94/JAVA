package model;

import java.util.HashMap;


/**
 *
 *
 *
 * The LetterModel performs all the algorithm for the calcuations needed. It
 * doesn't know the View exists
 *
 * @author Rafał Miąsko
 * @version 2.0
 *
 */
public class LetterModel {

    /**
     * Holds the value (letters and statistics) in the HashMap
     */
    public HashMap<Character, Integer> counter = new HashMap<>();

    /**
     * sumResult holds the value of sum
     */
    private double sumResult;

    /**
     * enum - holds the value of Statistic Letters
     */
    public enum statisticOfLetters {

        A(6.22), B(1.18), C(1.91), D(3.51), E(9.57),
        F(1.65), G(1.62), H(4.72), I(5.11), J(0.112),
        K(0.849), L(3.36), M(1.97), N(4.92), O(5.48),
        P(1.46), Q(0.077), R(4.58), S(5.03), T(6.68),
        U(2.25), V(0.605), W(1.59), X(0.091), Y(1.52), Z(0.057);

        private final double STATISTIC;

        /**
         *
         * constructor of enum
         *
         * @param statistic value of enum statistic
         */
        statisticOfLetters(double statistic) {
            this.STATISTIC = statistic;
        }

    }

    /**
     * method HashMap hold the value of letters with counter
     *
     * @param letters is the String with letters
     * @return hashmap with single letters eand counts
     * @throws WrongArgumentsException when when wrong character ( digit or
     * other)
     *
     */
    public HashMap<Character, Integer> hashmap(String letters) throws WrongArgumentsException {
        if ((letters == null)  ) {

            throw new WrongArgumentsException("string is null");

        } else if(letters.isEmpty())
                {
                    throw new WrongArgumentsException("String is empty");
                }
        for (int i = 0; i < letters.length(); ++i) {

            if (!Character.isLetter(letters.charAt(i))) {

                throw new WrongArgumentsException("change the data  without digit");
            }
        }
        /**
         * chars() return an IntStream of char values from this sequence
         */
        letters.chars()
                .mapToObj(c -> (char) c)
                .forEach((Character c) -> {

                    Integer count = counter.getOrDefault(c, 0);
                    counter.put(c, ++count);

                });

        return counter;
    }

    /**
     * method getSumResult return a private variable with sum
     *
     * @return private variable sumResult
     */
    public double getSumResult() {
        return sumResult;
    }

    /**
     * method resultOfSum(String) give the score of the sum of STATISTIC
     *
     *
     * @param data is the String with Letters
     * @throws WrongArgumentsException when wrong character ( digit or other)
     */
    public void resultOfSum(String data) throws WrongArgumentsException {

        for (HashMap.Entry<Character, Integer> entry : counter.entrySet()) {

            if (counter.isEmpty()) {

                throw new WrongArgumentsException("no data for the calculate");
            }

            sumResult += Math.abs((entry.getValue() / data.length()) - (statisticOfLetters.valueOf(entry.getKey().toString()).STATISTIC));

        }

    }
}

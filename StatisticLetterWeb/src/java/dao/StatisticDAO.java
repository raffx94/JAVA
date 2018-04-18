/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 * the class with DAO get and set the variable
 *
 * @author Rafał Miąsko
 * @version 3.0
 */
public class StatisticDAO {

    private int id;
    private String string;
    private Double score;

    /**
     * method get the value of statistic
     *
     * @return private value score which is value of statistic
     */
    public Double getScore() {
        return score;
    }

    /**
     * method get value String
     *
     * @return private value string which is string text
     */
    public String getString() {
        return string;
    }

    /**
     * Set the string value
     *
     * @param str is a value of the text
     */
    public void setString(String str) {
        this.string = str;
    }

    /**
     * Set the double value score
     *
     * @param scor is a calculate value
     */
    public void setScore(Double scor) {
        this.score = scor;
    }

}

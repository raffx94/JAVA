/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.GregorianCalendar;



/**
 *
 * @author Rafał
 */


public class Kierownik extends Pracownik{
    private double dodatek;

    public Kierownik() {
    }

    public Kierownik(String imie, String nazwisko, GregorianCalendar dataUr) {
        super(imie, nazwisko, dataUr);
    }

    public double getDodatek() {
        return dodatek;
    }

    public void setDodatek(double dodatek) {
        this.dodatek = dodatek;
    }
    

 
}

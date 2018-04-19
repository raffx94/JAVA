/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.GregorianCalendar;


/**
 *
 * @author Rafał
 */

public class Dziecko extends Osoba implements Serializable{

    private Adres adres;

    public Dziecko() {
    }

    public Dziecko(String imie, String nazwisko) {
        super(imie, nazwisko);
    }

    public Dziecko(String imie, String nazwisko, GregorianCalendar dataUr) {
        super(imie, nazwisko, dataUr);
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }
    

}

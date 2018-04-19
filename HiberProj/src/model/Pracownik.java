/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Rafał
 */


public class Pracownik extends Osoba implements Serializable{


 private Adres adres;
 private String stanowisko;

 

 private Dzial dzial;

 private Set<Dziecko> dzieci = new HashSet<>(3);


 
 private Set<Projekt> projekty = new HashSet<>(3);

    public Pracownik() {
    }

    public Pracownik(String imie, String nazwisko, GregorianCalendar dataUr) {
       super(imie, nazwisko, dataUr);
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Dzial getDzial() {
        return dzial;
    }

    public void setDzial(Dzial dzial) {
        this.dzial = dzial;
    }

    public Set<Dziecko> getDzieci() {
        return dzieci;
    }

    public void setDzieci(Set<Dziecko> dzieci) {
        this.dzieci = dzieci;
    }

    public Set<Projekt> getProjekty() {
        return projekty;
    }

    public void setProjekty(Set<Projekt> projekty) {
        this.projekty = projekty;
    }
@Override
    public String toString() {
      return (super.getImie() + " "
              +super.getNazwisko() + " ur. " + super.getDataUrS()
              +" stanowisko: "+ stanowisko);
    }
}

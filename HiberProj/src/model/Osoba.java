/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;



/**
 *
 * @author Rafał
 */

public class Osoba implements Serializable{
    
    private int id;
    
  
    private String imie;
   
  
    private String nazwisko;
    
    
    private GregorianCalendar dataUr;

    public Osoba() {
    }
    
    public Osoba(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public Osoba(String imie, String nazwisko, GregorianCalendar dataUr) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUr = dataUr;
    }

    @Override
    public String toString() {
      return (getImie() + " "+getNazwisko() + " ur. " + getDataUrS());
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public GregorianCalendar getDataUr() {
        return dataUr;
    }
    public String getDataUrS(){
        return(dataUr.get(Calendar.YEAR)+"-"+(dataUr.get(Calendar.MONTH)+1)
                +"-"+dataUr.get(Calendar.DAY_OF_MONTH));
    }

    public void setDataUr(GregorianCalendar dataUr) {
        this.dataUr = dataUr;
    }
    public int getWiek(){
         if (dataUr != null) {
             return(Calendar.getInstance().get(Calendar.YEAR)-dataUr.get(Calendar.YEAR));
         }
         else {
             return(0);
         } 
    }
    
}

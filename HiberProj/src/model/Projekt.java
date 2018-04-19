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

public class Projekt implements Serializable {

    
    private int id;
    private String nazwa;
    private GregorianCalendar dataRoz;
    private GregorianCalendar dataZak;

    

    private Set<Pracownik> pracownicy = new HashSet<>(10);

    public Projekt() {
    }

    public Projekt(String nazwa, GregorianCalendar dataRoz, GregorianCalendar dataZak) {
        this.nazwa = nazwa;
        this.dataRoz = dataRoz;
        this.dataZak = dataZak;
    }

    public GregorianCalendar getDataRoz() {
        return dataRoz;
    }

    public void setDataRoz(GregorianCalendar dataRoz) {
        this.dataRoz = dataRoz;
    }

    public GregorianCalendar getDataZak() {
        return dataZak;
    }

    public void setDataZak(GregorianCalendar dataZak) {
        this.dataZak = dataZak;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Set<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(Set<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    public String getDaty() {
        return dataRoz.get(GregorianCalendar.YEAR)
                + "-"
                + (dataRoz.get(GregorianCalendar.MONTH) + 1)
                + "-"
                + dataRoz.get(GregorianCalendar.DAY_OF_MONTH) 
                + " "
                + dataZak.get(GregorianCalendar.YEAR) 
                + "-" 
                + (dataZak.get(GregorianCalendar.MONTH) + 1)
                + "-" 
                + dataZak.get(GregorianCalendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return ("Projekt: " + getNazwa() + " Okres: "
                + getDaty());
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Rafał
 */

public class Dzial implements Serializable{

    private int id;
    private String nazwa;
 
    private Set<Pracownik> pracownicy = new HashSet<>(10);
    

   
    private Kierownik kierownik;
    
    public Dzial() {
    }

    public Dzial(String nazwa) {
        this.nazwa = nazwa;
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

    public Kierownik getKierownik() {
        return kierownik;
    }

    public void setKierownik(Kierownik kierownik) {
        this.kierownik = kierownik;
    }
    
}

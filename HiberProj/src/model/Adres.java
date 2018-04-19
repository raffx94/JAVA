/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.Serializable;




/**
 *
 * @author Rafał
 */


public class Adres implements Serializable{
    
    private int id;
    private String kod;
    private String miasto;
    private String ulica;
    private String nrDomu;
    private String nrMieszkania;

    public Adres() {
    }

    public Adres(String kod, String miasto, String ulica, String nrDomu, String nrMieszkania) {
        this.kod = kod;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
    }

    @Override
    public String toString() {
        return (" "+kod + " " + miasto + " ul." + ulica + " " + nrDomu + "/" + nrMieszkania+" ");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    public String getNrMieszkania() {
        return nrMieszkania;
    }

    public void setNrMieszkania(String nrMieszkania) {
        this.nrMieszkania = nrMieszkania;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

}

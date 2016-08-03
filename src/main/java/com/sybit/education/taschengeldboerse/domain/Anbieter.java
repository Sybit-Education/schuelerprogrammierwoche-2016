/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author sat
 */
@Entity(name = "anbieter")
public class Anbieter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Size(min = 5, message = "Bitte E-Mail angeben")
    @Column(unique = true, name = "emailadresse")
    private String emailadresse;

    @Column(name = "Anrede")
    private String anrede;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Name")
    private String name;

    @Column(name = "Strasse")
    private String strasse;
    
    @Column(name = "Plz")
    private String plz;
    
    @Column(name = "Wohnort")
    private String wohnort;
    
    @Column(name = "Telefonnummer")
    private String telefon;
 
    public Anbieter() {
    }

    public Anbieter(User user) {
        this.emailadresse = user.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer ID) {
        this.id = ID;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String Anrede) {
        this.anrede = Anrede;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String Vorname) {
        this.vorname = Vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }


    public String getEmailadresse() {
        return emailadresse;
    }

    public void setEmailadresse(String emailadresse) {
        this.emailadresse = emailadresse;
    }
    
    public String getStrasse() {
        return strasse;
    }
    
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }
    
    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }
    
    public String getWohnort() {
        return wohnort;
    }
    
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    public String getTelefon() {
        return telefon;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        hash = 43 * hash + Objects.hashCode(this.anrede);
        hash = 43 * hash + Objects.hashCode(this.vorname);
        hash = 43 * hash + Objects.hashCode(this.name);


        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Anbieter other = (Anbieter) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }        
        if (!Objects.equals(this.anrede, other.anrede)) {
            return false;
        }
        if (!Objects.equals(this.vorname, other.vorname)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
             
        return true;
    }


}

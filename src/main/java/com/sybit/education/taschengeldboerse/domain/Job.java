/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author sat
 */
@Entity
@Table(name = "jobs")
public class Job implements Serializable {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "bezeichnung")
    private String bezeichnung;

    @Column(name = "anbieter")
    private Integer anbieter;

    @Column(name = "datum")
    private String datum;
    
    @Column(name = "uhrzeit")
    private String uhrzeit;
    
    @Column(name = "zeitaufwand")
    private String zeitaufwand;
    
    @Column(name = "turnus")
    private boolean turnus;
    
    @Column(name = "anforderungen")
    private String anforderungen;
    
    @Column(name = "zusaetzliche_infos")
    private String zusaetzliche_infos;
    
    @Column(name = "entlohnung")
    private String entlohnung;

   

    public Job() {
    }

    ;
    
    public Job(String bezeichnung, Integer Anbieter) {
        this.bezeichnung = bezeichnung;
        this.anbieter = Anbieter;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String Bezeichnung) {
        this.bezeichnung = Bezeichnung;
    }

    public Integer getAnbieter() {
        return anbieter;
    }

    public void setAnbieter(Integer Anbieter) {
        this.anbieter = Anbieter;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getUhrzeit() {
        return uhrzeit;
    }
    
    public void setUhrzeit(String uhrzeit) {
        this.uhrzeit = uhrzeit;
    }
    
    public String getZeitaufwand() {
        return zeitaufwand;
    }
    
    public void setZeitaufwand(String zeitaufwand) {
        this.zeitaufwand = zeitaufwand;
    }
    
    public boolean getTurnus() {
        return turnus;
    }
    
    public void setTurnus(boolean turnus) {
        this.turnus = turnus;
    }
    
    public String getAnforderungen() {
        return anforderungen;
    }
    
    public void  setAnforderungen(String anforderungen) {
        this.anforderungen = anforderungen;
    }
    
    public void setZusaetzliche_infos(String zusaetzliche_infos) {
        this.zusaetzliche_infos = zusaetzliche_infos;
    }
    
    public String getZusaetzliche_infos() {
        return zusaetzliche_infos;
    }
    
    public String getEntlohnung() {
        return entlohnung;
    }
    
    public void setEntlohnung(String entlohnung) {
        this.entlohnung = entlohnung;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.bezeichnung);
        hash = 17 * hash + Objects.hashCode(this.anbieter);
        hash = 17 * hash + Objects.hashCode(this.datum);
        hash = 17 * hash + Objects.hashCode(this.uhrzeit);
        hash = 17 * hash + Objects.hashCode(this.zeitaufwand);
        hash = 17 * hash + Objects.hashCode(this.turnus);
        hash = 17 * hash + Objects.hashCode(this.anforderungen);
        hash = 17 * hash + Objects.hashCode(this.zusaetzliche_infos);
        hash = 17 * hash + Objects.hashCode(this.entlohnung);
        
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
        final Job other = (Job) obj;
        if (!Objects.equals(this.bezeichnung, other.bezeichnung)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.anbieter, other.anbieter)) {
            return false;
        }
        if (!Objects.equals(this.datum, other.datum)) {
            return false;
        }
        if (!Objects.equals(this.uhrzeit, other.uhrzeit)) {
            return false;
        }
        if (!Objects.equals(this.turnus, other.turnus)) {
            return false;
        }
        if (!Objects.equals(this.anforderungen, other.anforderungen)) {
            return false;
        }
        if (!Objects.equals(this.zusaetzliche_infos, other.zusaetzliche_infos)) {
            return false;
        }
        if (!Objects.equals(this.entlohnung, other.entlohnung)) {
            return false;
        }
        
        return true;
    }

}

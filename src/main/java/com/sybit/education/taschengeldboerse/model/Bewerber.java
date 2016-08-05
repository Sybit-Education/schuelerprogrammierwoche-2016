/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.model;

import java.util.Date;

/**
 *
 * @author Schulungsnb02
 */
public class Bewerber {
    
    private Integer schuelerId;
    
    private String vorname;
    
    private String nachname;
    
    private Date timestamp;

    public Integer getSchuelerId() {
        return schuelerId;
    }

    public void setSchuelerId(Integer schuelerId) {
        this.schuelerId = schuelerId;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
    
}

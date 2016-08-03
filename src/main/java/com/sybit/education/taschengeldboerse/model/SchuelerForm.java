/*
 * Schuelerprojekt: Taschengeldboerse
 * Sybit GmbH - www.sybit.de -  Apache License, Version 2.0
 * https://github.com/Sybit-Education/schuelerprogrammierwoche-201
 */
package com.sybit.education.taschengeldboerse.model;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Schulungsnb04
 */
public class SchuelerForm {
    
    @NotNull
    private String vorname;
    
    @NotNull
    private String anrede;
    
    @NotNull
    private String name;

    @Size(min = 5, message = "Bitte E-Mail angeben")   
    private String email;
    
    @NotNull
    private String DOBMonth;
   
    @NotNull
    private String DOBDay;
    
    @NotNull
    private String DOBYear;
     
    private String plz;
   
    private String wohnort; 
    
    @NotNull
    private String password;
    
    @NotNull
    private String passwordWdh;

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getAnrede() {
        return anrede;
    }

    public void setAnrede(String anrede) {
        this.anrede = anrede;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDOBMonth() {
        return DOBMonth;
    }

    public void setDOBMonth(String DOBMonth) {
        this.DOBMonth = DOBMonth;
    }

    public String getDOBDay() {
        return DOBDay;
    }

    public void setDOBDay(String DOBDay) {
        this.DOBDay = DOBDay;
    }

    public String getDOBYear() {
        return DOBYear;
    }

    public void setDOBYear(String DOBYear) {
        this.DOBYear = DOBYear;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordWdh() {
        return passwordWdh;
    }

    public void setPasswordWdh(String passwordWdh) {
        this.passwordWdh = passwordWdh;
    }
}

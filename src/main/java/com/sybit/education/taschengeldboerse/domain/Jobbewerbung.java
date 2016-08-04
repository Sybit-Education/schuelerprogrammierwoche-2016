/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Schulungsnb03
 */
@Entity
@Table(name = "jobbewerbung")
public class Jobbewerbung implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "schuelerid")
    private Integer schuelerid;
    @Column(name = "jobid")
    private Integer jobid;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestamp;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    public Jobbewerbung() {
    }

    public Jobbewerbung(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchuelerid() {
        return schuelerid;
    }

    public void setSchuelerid(Integer schuelerid) {
        this.schuelerid = schuelerid;
    }

    public Integer getJobid() {
        return jobid;
    }

    public void setJobid(Integer jobid) {
        this.jobid = jobid;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jobbewerbung that = (Jobbewerbung) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (schuelerid != null ? !schuelerid.equals(that.schuelerid) : that.schuelerid != null) return false;
        if (jobid != null ? !jobid.equals(that.jobid) : that.jobid != null) return false;
        if (timestamp != null ? !timestamp.equals(that.timestamp) : that.timestamp != null) return false;
        return status == that.status;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (schuelerid != null ? schuelerid.hashCode() : 0);
        result = 31 * result + (jobid != null ? jobid.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Jobbewerbung{" +
                "id=" + id +
                ", schuelerid=" + schuelerid +
                ", jobid=" + jobid +
                ", timestamp=" + timestamp +
                ", status=" + status +
                '}';
    }
}

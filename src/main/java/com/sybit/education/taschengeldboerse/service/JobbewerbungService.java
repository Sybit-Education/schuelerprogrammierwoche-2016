/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import java.util.List;

/**
 *
 * @author Schulungsnb03
 */
public interface JobbewerbungService {
    List<Jobbewerbung> findAll();
    List<Jobbewerbung> findAllBySchuelerid(Integer schuelerid);
    List<Jobbewerbung> findAllByJobid(Integer jobid);
    List<Jobbewerbung> bewerberListeAktualisieren(Integer jobId);
    
    Jobbewerbung findByJobidAndSchuelerid(Integer jobid, Integer schuelerid);
    
}

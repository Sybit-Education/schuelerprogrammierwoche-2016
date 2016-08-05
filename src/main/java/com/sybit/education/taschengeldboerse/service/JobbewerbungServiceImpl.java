/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.Status;
import com.sybit.education.taschengeldboerse.model.Bewerber;
import com.sybit.education.taschengeldboerse.repository.JobBewerbungRepository;
import com.sybit.education.taschengeldboerse.repository.SchuelerRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author Schulungsnb03
 */
@Service
public class JobbewerbungServiceImpl implements JobbewerbungService {
   
    @Autowired
    JobBewerbungRepository jobbewerbungrepository;
    
    @Autowired
    SchuelerRepository schuelerRepository;

    @Autowired
    EntityManager entityManager;
            
    @Override
    public List<Jobbewerbung> findAll() {
      return jobbewerbungrepository.findAll();
    }

    @Override
    public List<Jobbewerbung> findAllBySchuelerid(Integer schuelerid) {
       return jobbewerbungrepository.findAllBySchuelerid(schuelerid);
    }

    @Override
    public List<Jobbewerbung> findAllByJobid(Integer jobid) {
      return jobbewerbungrepository.findAllByJobid(jobid);
    }
    
    @Override
    public List<Jobbewerbung> findAllByStatusAndSchuelerId(Status status, int schuelerId){
        return jobbewerbungrepository.findAllByStatusAndSchuelerId(status, schuelerId);
    }

    @Override
    public List<Jobbewerbung> bewerberListeAktualisieren(Integer jobId){
        // Bestehende Bewerbungen zum selben Job ablehnen
        List<Jobbewerbung> bewerbungsListe = findAllByJobid(jobId);
        for(Jobbewerbung aktuelleBewerbung : bewerbungsListe ) {
            if(Status.PENDING.equals(aktuelleBewerbung.getStatus())) {
                aktuelleBewerbung.setStatus(Status.DECLINED);
                jobbewerbungrepository.saveAndFlush(aktuelleBewerbung);
            }
        }
        return bewerbungsListe;
    }

    @Override
    public Jobbewerbung findByJobidAndSchuelerid(Integer jobid, Integer schuelerid) {
        return jobbewerbungrepository.findByJobidAndSchuelerid(jobid, schuelerid);
    }

    @Override
    public List<Bewerber> getAllBewerberByJobid(Integer jobid) {
        List<Bewerber> bewerberList = new ArrayList<>();
       
        for(Jobbewerbung jobbewerbung : jobbewerbungrepository.findAllByJobid(jobid)) {
            Bewerber bewerber = new Bewerber();
            bewerber.setTimestamp(jobbewerbung.getTimestamp());
            
            Schueler schueler = schuelerRepository.findById(jobbewerbung.getSchuelerid());
            bewerber.setSchuelerId(schueler.getId());
            bewerber.setVorname(schueler.getVorname());
            bewerber.setNachname(schueler.getName());
            
            bewerberList.add(bewerber);
        }
        return bewerberList;
    }
}

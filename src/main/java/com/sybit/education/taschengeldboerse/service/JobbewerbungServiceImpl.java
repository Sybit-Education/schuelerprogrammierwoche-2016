/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Status;
import com.sybit.education.taschengeldboerse.repository.JobBewerbungRepository;
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
    public void bewerbungAnnehmen(Integer jobId, Integer schuelerId){
        List<Jobbewerbung> bewerbungsListe = findAllByJobid(jobId);
        bewerbungsListe.get(schuelerId).setStatus(Status.ACCEPTED);
        for(Jobbewerbung bewerbung : bewerbungsListe) {
            if (bewerbung.getSchuelerid() != schuelerId){
                bewerbung.setStatus(Status.DECLINED);
            }
        }

    }

    @Override
    public Jobbewerbung findByJobidAndSchuelerid(Integer jobid, Integer schuelerid) {
        return jobbewerbungrepository.findByJobidAndSchuelerid(jobid, schuelerid);
    }
}

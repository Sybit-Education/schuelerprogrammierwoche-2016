/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.repository.JobBewerbungRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Schulungsnb03
 */
@Service
public class JobbewerbungServiceImpl implements JobbewerbungService {
   
    @Autowired
    JobBewerbungRepository jobbewerbungrepository;
    
            
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


}

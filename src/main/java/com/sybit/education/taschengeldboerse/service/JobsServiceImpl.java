/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.Status;
import com.sybit.education.taschengeldboerse.repository.JobBewerbungRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sybit.education.taschengeldboerse.repository.JobsRepository;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Implementierung des Services für die Jobs.
 * 
 */
@Service
public class JobsServiceImpl implements JobsService {
  private static final Logger LOGGER = LoggerFactory.getLogger(JobsServiceImpl.class);
    @Autowired
    JobsRepository jobRepository;
    
    @Autowired
    JobBewerbungRepository jobBewerbungRepository;
    
    @Autowired
    UserService userService;
    
    //TODO: Wann brauchen wir den?!
    @Autowired
    private JobbewerbungService jobBewerbungService;
    
    /**
     * Lade alle Jobs.
     * 
     * @return 
     */
    @Override
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    /**
     * Neuen Job hinufügen.
     * 
     * @param job 
     */
    @Override
    public Job addJob(Job job) {
        
        if(job.getAnbieter() == null) {
            job.setAnbieter(1); //zum Standardbenutzer hinzufügen. Muss noch geändert werden.
        }
        Job savedJob = jobRepository.save(job);
        
        return savedJob;
    }
    
    /**
     * Job anhand der id aus der datenbank laden.
     * 
     * @param id
     * @return 
     */
    @Override
    public Job findById(Integer id) {
        return jobRepository.findOne(id);
    }
    
    /**
     * Schüler-Bewerbung auf einen Job wird angelegt. 
     * 
     * @param schuelerEmail
     * @param jobId 
     */
    @Override
    public void bewerben(String schuelerEmail, Integer jobId) {
        LOGGER.debug("bewerben von benutzer " + schuelerEmail + " für Job id " + jobId);

        Schueler schueler = userService.getSchuelerByEmail(schuelerEmail);
        Jobbewerbung bewerbung = new Jobbewerbung();
        bewerbung.setSchuelerid(schueler.getId());
        bewerbung.setJobid(jobId);
        bewerbung.setTimestamp(new Date());
        bewerbung.setStatus(Status.PENDING);
        jobBewerbungRepository.save(bewerbung);
    }
    
    @Override
    public List<Job> getFreeJobs() {
       return jobRepository.findBySchuelerIsNull();
    }

    @Override
    public List<Job> getJobsOfAnbieter(Anbieter anbieter) {
        return jobRepository.findByAnbieter(anbieter.getId());
    }
 
    @Override
    public List<Job> getFreeJobsOfAnbieter(Anbieter anbieter) {
        return jobRepository.findByAnbieterAndSchuelerIsNull(anbieter.getId());
    }

}

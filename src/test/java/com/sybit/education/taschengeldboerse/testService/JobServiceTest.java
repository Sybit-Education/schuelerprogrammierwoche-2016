/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.testService;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Status;
import com.sybit.education.taschengeldboerse.service.JobbewerbungService;
import com.sybit.education.taschengeldboerse.testutil.AbstractDatabaseTest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import com.sybit.education.taschengeldboerse.service.JobsService;
import static org.junit.Assert.assertEquals;

/**
 * Test for JobService.
 *
 */
public class JobServiceTest extends AbstractDatabaseTest {

    @Autowired
    JobbewerbungService jobbewerbungservice;
    
    @Autowired
    JobsService service;

    @Test
    public void testFindAll() {
        List<Job> jobList = service.getAllJobs();
        assertEquals(5, jobList.size());

        Job job = jobList.get(0);
        assertEquals("Test Job", job.getBezeichnung());
        assertEquals("test info", job.getZusaetzliche_infos());
    }

    @Test
    public void testFindBySchuelerIsNull() {
        Integer schulerid = 7;
        List<Job> jobList = service.getFreeJobs(schulerid);
        assertEquals(2, jobList.size());
    }

    @Test
    public void testFindByAnbieterAndSchuelerIsNull() {
        Anbieter anbieter = new Anbieter();
        anbieter.setId(3);
        List<Job> jobList = service.getFreeJobsOfAnbieter(anbieter);
        assertEquals(2, jobList.size());
    }

    @Test
    public void testFindByAnbieter() {
        Anbieter anbieter = new Anbieter();
        anbieter.setId(2);
        List<Job> jobList = service.getJobsOfAnbieter(anbieter);
        assertEquals(2, jobList.size());
    }

    @Test
    public void testFindByAnbieter2() {
        Anbieter anbieter = new Anbieter();
        anbieter.setId(1);
        List<Job> jobList = service.getJobsOfAnbieter(anbieter);
        assertEquals(1, jobList.size());
    }
    
    @Test
    public void testBewerberAnnehmen(){
        Integer jobId = 3;
        Integer schuelerId = 6;
        List<Jobbewerbung> bewerbungsListe = jobbewerbungservice.findAllByJobid(3);
        assertEquals(3, bewerbungsListe.size());

        //TODO
        service.bewerbungAnnehmen(jobId, schuelerId);
        //assertEquals(Status.ACCEPTED, bewerbungsListe.get(2).getStatus());
        //assertEquals(Status.DECLINED, bewerbungsListe.get(1).getStatus());
        //assertEquals(Status.DECLINED, bewerbungsListe.get(0).getStatus());
    }
    
    @Override
    public String getDataset() {
        return "database/testJobService.xml";
    }

}

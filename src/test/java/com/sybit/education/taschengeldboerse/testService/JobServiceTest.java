/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.testService;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.Job;
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
        List<Job> jobList = service.getFreeJobs();
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
    @Override
    public String getDataset() {
        return "database/testJobService.xml";
    }
    
}

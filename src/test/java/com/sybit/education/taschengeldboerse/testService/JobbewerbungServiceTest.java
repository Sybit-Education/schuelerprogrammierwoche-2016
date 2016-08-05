/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.testService;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Status;
import com.sybit.education.taschengeldboerse.service.JobbewerbungService;
import com.sybit.education.taschengeldboerse.service.JobsService;
import com.sybit.education.taschengeldboerse.testutil.AbstractDatabaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 *
 * @author Schulungsnb03
 */
public class JobbewerbungServiceTest extends AbstractDatabaseTest{
    
    @Autowired
    JobbewerbungService jobbewerbungservice;
    
    @Test
    public void testFindByJobidAndSchuelerId() {
        int jobId = 5;
        int schuelerId = 3;
        Jobbewerbung bewerbung = jobbewerbungservice.findByJobidAndSchuelerid(jobId, schuelerId);
        assertNotEquals(null, bewerbung);
    }
    
    @Test
    public void testFindAll() {
        List<Jobbewerbung> jobList = jobbewerbungservice.findAll();
        assertEquals(8, jobList.size());
    }
    
    @Test
    public void testFindAllBySchuelerId(){ 
        int schuelerId = 3;
        List<Jobbewerbung> jobList = jobbewerbungservice.findAllBySchuelerid(schuelerId);
        assertEquals(4, jobList.size());
    }
    
    @Test 
    public void testFindAllByJobId(){
        int jobid = 3;
        List<Jobbewerbung> jobList = jobbewerbungservice.findAllByJobid(jobid);
        assertEquals(3, jobList.size());
    }
    
    @Override
    public String getDataset() {
        return "database/JobbewerbungServiceTest.xml";
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import java.util.List;

/**
 *
 * @author sat
 */
public interface JobsService {

    List<Job> getAllJobs();

    List<Job> getFreeJobs(Integer schuelerId);

    Job addJob(Job job);

    Job findById(Integer id);

    List<Job> getJobsOfAnbieter(Anbieter anbieter);

    List<Job> getFreeJobsOfAnbieter(Anbieter anbieter);
    
    List<Job> getAssignedJobsOfAnbieter(Anbieter anbieter);

    void bewerben(String schuelerEmail, Integer jobId);
    
    void bewerbungAnnehmen(Integer jobId, Integer schuelerId);

}

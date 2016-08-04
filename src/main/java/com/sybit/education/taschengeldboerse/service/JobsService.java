/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.domain.Job;
import java.util.List;

/**
 *
 * @author sat
 */
public interface JobsService {

    List<Job> getAllJobs();

    List<Job> getFreeJobs();

    Job addJob(Job job);

    Job findById(Integer id);

    List<Job> getJobsOfAnbieter(Anbieter anbieter);

    List<Job> getFreeJobsOfAnbieter(Anbieter anbieter);

    void bewerben(String username, Integer jobId);
    
    boolean isJobOfSchueler(Integer schuelerId, Integer jobId);

}

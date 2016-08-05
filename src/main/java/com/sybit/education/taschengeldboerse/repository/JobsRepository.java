/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.repository;

import com.sybit.education.taschengeldboerse.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author sat
 */
public interface JobsRepository extends JpaRepository<Job, Integer>{
    
   
    Job findById(Integer id);
    
    List<Job> findBySchuelerIsNull();
    
    List<Job> findByAnbieter(Integer id);
    
    List<Job> findByAnbieterAndSchuelerIsNull(Integer id);

    List<Job> findAllBySchueler(Integer schuelerid);
}   
    

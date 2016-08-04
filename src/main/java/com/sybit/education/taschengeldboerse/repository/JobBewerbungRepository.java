/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.repository;

import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Schulungsnb03
 */
@Repository
public interface JobBewerbungRepository extends JpaRepository<Jobbewerbung, Integer>{
    
    List<Jobbewerbung> findAll();
    List<Jobbewerbung> findAllBySchuelerid(Integer schuelerid);
    List<Jobbewerbung> findAllByJobid(Integer jobid);
    
    Jobbewerbung findByJobidAndSchuelerid(Integer jobid, Integer schuelerid);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.repository;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author Schulungsnb03
 */
@Repository
public interface JobBewerbungRepository extends JpaRepository<Jobbewerbung, Integer>, JobBewerbungRepositoryCustom {
    
    List<Jobbewerbung> findAll();
    List<Jobbewerbung> findAllBySchuelerid(Integer schuelerid);
    List<Jobbewerbung> findAllByJobid(Integer jobid);
    List<Jobbewerbung> findAllBySchueleridAndStatus(Integer schuelerid, Status status);
    Jobbewerbung findByJobidAndSchuelerid(Integer jobid, Integer schuelerid);
}

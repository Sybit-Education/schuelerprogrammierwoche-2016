/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.repository;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import java.util.List;

/**
 *
 * @author Schulungsnb03
 */
public interface JobBewerbungRepository {
    List<Jobbewerbung> findAll();
    List<Jobbewerbung> findAllBySchuelerId(Integer schuelerid);
    List<Jobbewerbung> findAllByJobId(Integer jobid);
    
    
}

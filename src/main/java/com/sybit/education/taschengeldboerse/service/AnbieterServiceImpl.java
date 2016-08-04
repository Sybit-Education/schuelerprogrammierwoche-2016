/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Anbieter;
import com.sybit.education.taschengeldboerse.repository.AnbieterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author frz
 */
@Service
public class AnbieterServiceImpl implements AnbieterService {
    
    @Autowired
    AnbieterRepository anbieterRepository;
    
    @Override
    public Anbieter findAnbieterById(int id){
        return anbieterRepository.findById(id);
    }
    
}

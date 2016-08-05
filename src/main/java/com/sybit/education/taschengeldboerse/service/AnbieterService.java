/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Anbieter;

/**
 *
 * @author frz
 */
public interface AnbieterService {
    
    Anbieter findAnbieterById(int Id);
    
    void updateAnbieter(Anbieter anbieter);
}

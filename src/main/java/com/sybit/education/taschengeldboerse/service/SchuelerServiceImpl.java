package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.repository.SchuelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kkr on 03.08.2016.
 */
@Service
public class SchuelerServiceImpl implements SchuelerService {

    @Autowired
    SchuelerRepository schuelerRepository;

    @Override
    public Schueler findSchuelerById(int id) {
        return schuelerRepository.findById(id);
    }
}

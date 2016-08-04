package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.User;
import com.sybit.education.taschengeldboerse.repository.SchuelerRepository;
import com.sybit.education.taschengeldboerse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by kkr on 03.08.2016.
 */
@Service
public class SchuelerServiceImpl implements SchuelerService {

    @Autowired
    SchuelerRepository schuelerRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public Schueler findSchuelerById(int id) {
        return schuelerRepository.findById(id);
    }

    @Override
    public void updateSchueler(Schueler schueler) {
        Schueler updatedSchueler = schuelerRepository.findById(schueler.getId());
       /* User user = userRepository.findByEmail(updatedSchueler.getEmail());

        user.setEmail(schueler.getEmail());
        userRepository.save(user);*/

        updatedSchueler.setVorname(schueler.getVorname());
        updatedSchueler.setName(schueler.getName());
        updatedSchueler.setAnrede(schueler.getAnrede());
        //updatedSchueler.setEmail(schueler.getEmail());
        updatedSchueler.setGeburtsdatum(schueler.getGeburtsdatum());
        updatedSchueler.setPlz(schueler.getPlz());
        updatedSchueler.setWohnort(schueler.getWohnort());
        updatedSchueler.setImage(schueler.getImage());

        schuelerRepository.save(updatedSchueler);
    }
}

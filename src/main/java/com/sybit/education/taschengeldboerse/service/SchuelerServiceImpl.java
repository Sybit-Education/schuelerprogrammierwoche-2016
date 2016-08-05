package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Schueler;
import com.sybit.education.taschengeldboerse.domain.Status;
import com.sybit.education.taschengeldboerse.repository.JobBewerbungRepository;
import com.sybit.education.taschengeldboerse.repository.JobsRepository;
import com.sybit.education.taschengeldboerse.repository.SchuelerRepository;
import com.sybit.education.taschengeldboerse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kkr on 03.08.2016.
 */
@Service
public class SchuelerServiceImpl implements SchuelerService {

    @Autowired
    SchuelerRepository schuelerRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    JobBewerbungRepository jobBewerbungRepository;

    @Override
    public Schueler findSchuelerById(int id) {
        return schuelerRepository.findById(id);
    }

    @Override
    public List<Job> getSchuelerJobs(Integer schuelerid){
        return jobsRepository.findAllBySchueler(schuelerid);
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

    @Override
    public List<Jobbewerbung> getPendingSchuelerJobs(Integer schuelerid) {
        return jobBewerbungRepository.findAllBySchueleridAndStatus(schuelerid, Status.PENDING);
    }
}

package com.sybit.education.taschengeldboerse.service;

import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Schueler;

import java.util.List;

/**
 * Created by kkr on 03.08.2016.
 */
public interface SchuelerService {

    Schueler findSchuelerById(int Id);

    void updateSchueler(Schueler schueler);

    List<Job> getSchuelerJobs(Integer schuelerid);

    List<Jobbewerbung> getPendingSchuelerJobs(Integer schuelerid);
}

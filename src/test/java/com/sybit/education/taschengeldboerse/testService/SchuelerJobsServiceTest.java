package com.sybit.education.taschengeldboerse.testService;

import com.sybit.education.taschengeldboerse.domain.Job;
import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.service.SchuelerService;
import com.sybit.education.taschengeldboerse.testutil.AbstractDatabaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by tsa on 05.08.2016.
 */
public class SchuelerJobsServiceTest extends AbstractDatabaseTest{

    @Autowired
    SchuelerService schuelerService;

    @Test
    public void testFindAllJobsBySchuelerid() {
        List<Job> jobList = schuelerService.getSchuelerJobs(1);

        assertEquals(3, jobList.size());

    }

    @Test
    public void testGetSchuelerPendingJobs() {
        List<Jobbewerbung> jobbewerbungListe = schuelerService.getPendingSchuelerJobs(3);

        assertEquals(3, jobbewerbungListe.size());
    }
    @Override
    public String getDataset() {
        return "database/testJobService.xml";
    }
}

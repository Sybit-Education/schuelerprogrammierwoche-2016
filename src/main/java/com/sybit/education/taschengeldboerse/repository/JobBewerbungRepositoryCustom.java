package com.sybit.education.taschengeldboerse.repository;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import com.sybit.education.taschengeldboerse.domain.Status;
import java.util.List;

/**
 * Created by tsa on 04.08.2016.
 */
public interface JobBewerbungRepositoryCustom {

    public void refreshBewerbungsTable(Integer schuelerId);
    
    List<Jobbewerbung> findAllByStatusAndSchuelerId(Status status, Integer schuelerId);
}

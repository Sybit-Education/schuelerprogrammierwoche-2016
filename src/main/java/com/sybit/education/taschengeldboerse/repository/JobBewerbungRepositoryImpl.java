package com.sybit.education.taschengeldboerse.repository;

import com.sybit.education.taschengeldboerse.domain.Jobbewerbung;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by tsa on 04.08.2016.
 */
public class JobBewerbungRepositoryImpl implements JobBewerbungRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Override
    public void refreshBewerbungsTable(Integer schuelerId) {
        List<Jobbewerbung> bewerbungenListe;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Jobbewerbung> cq = cb.createQuery( Jobbewerbung.class );

        Root<Jobbewerbung> bewerbungen = cq.from( Jobbewerbung.class );

        Expression<String> schueleridFK = bewerbungen.get( "schuelerid" );

        cq.select( bewerbungen ).where( cb.equal( schueleridFK, schuelerId ) );

        Query query = entityManager.createQuery( cq );

        bewerbungenListe = query.getResultList();
    }
}

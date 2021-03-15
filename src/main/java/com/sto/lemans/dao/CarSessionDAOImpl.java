package com.sto.lemans.dao;

import com.sto.lemans.entity.CarSession;
import com.sto.lemans.exceptions.SessionException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class CarSessionDAOImpl implements CarSessionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CarSession> getAllSessions() {
        Session session = sessionFactory.getCurrentSession();
        List<CarSession> allSessions = session.createQuery("from CarSession " +
                "order by endTime", CarSession.class).getResultList();

        return allSessions;
    }

    @Override
    public void saveSession(CarSession carSession) throws SessionException {

        Session session = sessionFactory.getCurrentSession();

        List<CarSession> allSessions = session.createQuery("from CarSession", CarSession.class).getResultList();


        session.saveOrUpdate(carSession);
    }

    @Override
    public CarSession getSession(int id) {
        Session session = sessionFactory.getCurrentSession();
        CarSession carSession = session.get(CarSession.class, id);

        return carSession;
    }


    @Override
    public void deleteSession(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<CarSession> query = session.createQuery("delete from CarSession " +
                "where id =:sessionId");
        query.setParameter("sessionId", id);
        query.executeUpdate();
    }

    @Override
    public int count(){
        int count = 0;
        Session session = sessionFactory.getCurrentSession();
        List<CarSession> allSessions = session.createQuery("from CarSession " +
                "order by endTime", CarSession.class).getResultList();

        Date curDate = new Date();
        for (CarSession otherSession : allSessions) {
            if ((curDate.getTime() - otherSession.getEndTime().getTime()) < 2592000000L ) {count++;}
        }

        return count;
    }
}

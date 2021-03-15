package com.sto.lemans.dao;

import com.sto.lemans.entity.Master;
import com.sto.lemans.exceptions.MasterNumberException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MasterDAOImpl implements MasterDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Master> getAllMasters() {

        Session session = sessionFactory.getCurrentSession();
        List<Master> allMaster = session.createQuery("from Master", Master.class).getResultList();

        return allMaster;
    }

    @Override
    public void saveMaster(Master master) throws MasterNumberException {

        Session session = sessionFactory.getCurrentSession();

        List<Integer> ids = session.createQuery("select masterNumber from Master", Integer.class).getResultList();
        System.out.println(ids);
        for (Integer id : ids) {
            if (master.getMasterNumber() == id) {
                throw new MasterNumberException("Master with that number already exists!");
            }
        }
        session.saveOrUpdate(master);
    }

    @Override
    public Master getMaster(int id) {
        Session session = sessionFactory.getCurrentSession();
        Master master = session.get(Master.class, id);

        return master;
    }

    @Override
    public void deleteMaster(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query<Master> query = session.createQuery("delete from Master " +
                "where id =:masterId");
        query.setParameter("masterId", id);
        query.executeUpdate();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}

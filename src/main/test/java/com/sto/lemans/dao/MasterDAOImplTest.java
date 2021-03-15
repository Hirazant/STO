package com.sto.lemans.dao;

import com.sto.lemans.entity.Master;
import com.sto.lemans.entity.Client;
import com.sto.lemans.entity.CarSession;
import com.sto.lemans.exceptions.MasterNumberException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class MasterDAOImplTest {

    private MasterDAOImpl masterDAO;
    private final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Master.class)
            .addAnnotatedClass(Client.class)
            .addAnnotatedClass(CarSession.class)
            .buildSessionFactory();

    @Before
    public void setUp() {
        masterDAO = new MasterDAOImpl();
        masterDAO.setSessionFactory(sessionFactory);
    }

    @Test
    public void getAllMasters() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        List<Master> expected = masterDAO.getAllMasters();

        session.getTransaction().commit();

        Assert.assertNotNull(expected);
    }

    @Test(expected = MasterNumberException.class)
    public void masterMaster() throws MasterNumberException {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();

        Master testMaster = new Master(1, "testMaster", "testLastMaster", "testMiddleMaster", "testSpec");
        masterDAO.saveMaster(testMaster);

        session.getTransaction().commit();
    }
}
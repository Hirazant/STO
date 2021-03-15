package com.sto.lemans.service;

import com.sto.lemans.dao.CarSessionDAO;
import com.sto.lemans.entity.CarSession;
import com.sto.lemans.exceptions.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarSessionServiceImpl implements CarSessionService {

    @Autowired
    private CarSessionDAO carSessionDAO;

    @Override
    @Transactional
    public List<CarSession> getAllSessions() {
        return carSessionDAO.getAllSessions();
    }

    @Override
    @Transactional
    public void saveSession(CarSession session) throws SessionException {
        carSessionDAO.saveSession(session);
    }

    @Override
    @Transactional
    public CarSession getSession(int id) {

        return carSessionDAO.getSession(id);
    }

    @Override
    @Transactional
    public void deleteSession(int id) {
        carSessionDAO.deleteSession(id);
    }

    @Override
    @Transactional
    public int count(){return carSessionDAO.count();}
}

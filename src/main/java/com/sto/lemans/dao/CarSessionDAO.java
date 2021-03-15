package com.sto.lemans.dao;

import com.sto.lemans.entity.CarSession;
import com.sto.lemans.exceptions.SessionException;

import java.util.List;

public interface CarSessionDAO {
    List<CarSession> getAllSessions();

    void saveSession(CarSession carSession) throws SessionException;

    CarSession getSession(int id);

    void deleteSession(int id);

    int count();
}
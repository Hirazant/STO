package com.sto.lemans.service;

import com.sto.lemans.entity.CarSession;
import com.sto.lemans.exceptions.SessionException;

import java.util.List;

public interface CarSessionService {
    List<CarSession> getAllSessions();

    void saveSession(CarSession session) throws SessionException;

    CarSession getSession(int id);

    void deleteSession(int id);

    int count();
}

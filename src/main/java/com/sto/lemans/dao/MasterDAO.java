package com.sto.lemans.dao;

import com.sto.lemans.entity.Master;
import com.sto.lemans.exceptions.MasterNumberException;

import java.util.List;

public interface MasterDAO {
    List<Master> getAllMasters();

    void saveMaster(Master master) throws MasterNumberException;

    Master getMaster(int id);

    void deleteMaster(int id);
}

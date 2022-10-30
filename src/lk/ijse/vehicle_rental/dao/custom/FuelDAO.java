/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.SuperDAO;
import lk.ijse.vehicle_rental.entity.Fuel;

/**
 *
 * @author zoomcoder
 */
public interface FuelDAO extends SuperDAO {

    public String getFuel(String id) throws Exception;

    public ArrayList<Fuel> getAll() throws Exception;

    public Fuel get(String id) throws Exception;

    public String getFualID(String FualNAme) throws Exception;
}

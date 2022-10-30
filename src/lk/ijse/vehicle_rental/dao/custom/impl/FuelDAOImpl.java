/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.FuelDAO;
import lk.ijse.vehicle_rental.entity.Fuel;

/**
 *
 * @author zoomcoder
 */
public class FuelDAOImpl implements FuelDAO {

    @Override
    public String getFuel(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select FuelName from Fuel");
        String fuel = null;
        while (rst.next()) {
            fuel = rst.getString(1);

        }
        return fuel;

    }

    @Override
    public ArrayList<Fuel> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Fuel");

        ArrayList<Fuel> alFuel = new ArrayList<>();

        while (rst.next()) {
            Fuel fuel = new Fuel(
                    rst.getString(1),
                    rst.getString(2));

            alFuel.add(fuel);

        }
        return alFuel;
    }

    @Override
    public Fuel get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Fuel WHERE FID=?", id);

        Fuel fuel = null;

        if (rst.next()) {
            fuel = new Fuel(rst.getString(1),
                    rst.getString(2));
        }

        return fuel;
    }

    @Override
    public String getFualID(String FualNAme) throws Exception {
        ResultSet set = CrudUtil.executeQuery("select FID from Fuel where FuelName=?", FualNAme);
        String FID = null;
        if (set.next()) {
            FID = set.getString(1);
        }
        return FID;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.SuperDAO;
import lk.ijse.vehicle_rental.entity.Category;

/**
 *
 * @author zoomcoder
 */
public interface CategoryDAO extends SuperDAO {

    public String getCategory(String id) throws Exception;

    public ArrayList<Category> getAll() throws Exception;

    public Category get(String id) throws Exception;

    public String getCatID(String catName) throws Exception;
}

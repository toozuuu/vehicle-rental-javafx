/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.CategoryDAO;
import lk.ijse.vehicle_rental.entity.Category;

/**
 *
 * @author zoomcoder
 */
public class CategoryDAOImpl implements CategoryDAO {

    public ArrayList<Category> getAll() throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Category");

        ArrayList<Category> alCategory = new ArrayList<>();

        while (rst.next()) {
            Category category = new Category(
                    rst.getString(1),
                    rst.getString(2)
            );
            alCategory.add(category);
        }

        return alCategory;
    }

    @Override
    public Category get(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Category WHERE CID=?", id);

        Category category = null;

        if (rst.next()) {
            category = new Category(rst.getString(1),
                    rst.getString(2));
        }

        return category;
    }

    @Override
    public String getCategory(String id) throws Exception {
        ResultSet rst = CrudUtil.executeQuery("select CategoryName from Category");
        String category = null;
        while (rst.next()) {
            category = rst.getString(1);

        }
        return category;

    }

    @Override
    public String getCatID(String catName) throws Exception {
        ResultSet set = CrudUtil.executeQuery("select CID from Category where CategoryName=?", catName);
        String CID = null;
        if (set.next()) {
            CID = set.getString(1);
        }
        return CID;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.custom.CategoryBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.CategoryDAO;
import lk.ijse.vehicle_rental.dto.CategoryDTO;
import lk.ijse.vehicle_rental.entity.Category;

/**
 *
 * @author zoomcoder
 */
public class CategoryBOImpl implements CategoryBO {

    private CategoryDAO categoryDAO;

    public CategoryBOImpl() {
        categoryDAO = (CategoryDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.CATEGORY);

    }

    @Override
    public ArrayList<CategoryDTO> getAllCategory() throws Exception {
        ArrayList<Category> alCategory = categoryDAO.getAll();
        ArrayList<CategoryDTO> dtos = new ArrayList<>();
        for (Category category : alCategory) {
            dtos.add(new CategoryDTO(category.getCID(), category.getCategoryName()));
        }
        return dtos;
    }

    @Override
    public String getCatID(String catName) throws Exception {
        return categoryDAO.getCatID(catName);
    }

}

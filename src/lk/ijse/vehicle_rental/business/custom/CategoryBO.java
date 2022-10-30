/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.business.custom;

import java.util.ArrayList;
import lk.ijse.vehicle_rental.business.SuperBO;
import lk.ijse.vehicle_rental.dto.CategoryDTO;

/**
 *
 * @author zoomcoder
 */
public interface CategoryBO extends SuperBO {

    public ArrayList<CategoryDTO> getAllCategory() throws Exception;

    public String getCatID(String catName) throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.entity;

/**
 *
 * @author zoomcoder
 */
public class Category {
    private String CID;
    private String CategoryName;

    public Category() {
    }

    public Category(String CID, String CategoryName) {
        this.CID = CID;
        this.CategoryName = CategoryName;
    }

    /**
     * @return the CID
     */
    public String getCID() {
        return CID;
    }

    /**
     * @param CID the CID to set
     */
    public void setCID(String CID) {
        this.CID = CID;
    }

    /**
     * @return the CategoryName
     */
    public String getCategoryName() {
        return CategoryName;
    }

    /**
     * @param CategoryName the CategoryName to set
     */
    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    @Override
    public String toString() {
        return "Category{" + "CID=" + CID + ", CategoryName=" + CategoryName + '}';
    }

    
}

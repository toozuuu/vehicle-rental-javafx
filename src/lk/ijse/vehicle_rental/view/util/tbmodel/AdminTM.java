/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.vehicle_rental.view.util.tbmodel;

/**
 *
 * @author zoomcoder
 */
public class AdminTM {
    private String Name;
    private String Pass;

    public AdminTM() {
    }

    public AdminTM(String Name, String Pass) {
        this.Name = Name;
        this.Pass = Pass;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return the Pass
     */
    public String getPass() {
        return Pass;
    }

    /**
     * @param Pass the Pass to set
     */
    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    @Override
    public String toString() {
        return "AdminTM{" + "Name=" + Name + ", Pass=" + Pass + '}';
    }
    
    
}

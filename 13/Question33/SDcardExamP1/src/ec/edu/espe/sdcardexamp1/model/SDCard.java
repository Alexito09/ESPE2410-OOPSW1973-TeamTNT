/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.sdcardexamp1.model;

/**
 *
 * @author Leidy Saraguro,Paradigm Pioneers Squad, DCCO-ESPE
 */
public class SDCard {
    private int id;
    private String brand;
    private int capacityGB;
    private String type;

    public SDCard(int id, String brand, int capacityGB, String type) {
        this.id = id;
        this.brand = brand;
        this.capacityGB = capacityGB;
        this.type = type;
    }

    @Override
    public String toString() {
        return "SDCard{" + "id=" + id + ", brand=" + brand + ", capacityGB=" + capacityGB + ", type=" + type + '}';
    }
    
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * @param brand the brand to set
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * @return the capacityGB
     */
    public int getCapacityGB() {
        return capacityGB;
    }

    /**
     * @param capacityGB the capacityGB to set
     */
    public void setCapacityGB(int capacityGB) {
        this.capacityGB = capacityGB;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    
    
}

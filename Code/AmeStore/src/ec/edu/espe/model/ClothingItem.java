/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

/**
 *
 * @author PC
 */
public class ClothingItem {
    private String name;
   private double price;

    public ClothingItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ClothingItem{" + "name=" + name + ", price=" + price + '}';
    }

 
    public String getName() {
        return name;
    }

  
    public void setName(String name) {
        this.name = name;
    }

 
    public double getPrice() {
        return price;
    }

 
    public void setPrice(double price) {
        this.price = price;
    }

}

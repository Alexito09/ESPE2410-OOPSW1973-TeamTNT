/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Category {
    private String name;
    private ArrayList<ClothingItem> clothingItems;

    public Category(String name) {
        this.name = name;
        this.clothingItems = new ArrayList<>();
    }

    public void addClothingItem(ClothingItem item) {
        clothingItems.add(item);
    }

    public String getName() {
        return name;
    }

    public ArrayList<ClothingItem> getClothingItems() {
        return clothingItems;
    }

    public ClothingItem getClothingItemByName(String itemName) {
        for (ClothingItem item : clothingItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;  
    }
}


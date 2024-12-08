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

    // Add a clothing item to the category
    public void addClothingItem(ClothingItem item) {
        clothingItems.add(item);
    }

    // Get the category name
    public String getName() {
        return name;
    }

    // Get all clothing items in this category
    public ArrayList<ClothingItem> getClothingItems() {
        return clothingItems;
    }

    // Find a clothing item by name
    public ClothingItem getClothingItemByName(String itemName) {
        for (ClothingItem item : clothingItems) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item;
            }
        }
        return null;  // If item is not found
    }
}


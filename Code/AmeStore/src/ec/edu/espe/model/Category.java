package ec.edu.espe.model;

import ec.edu.espe.exceptions.InvalidCategoryException;
import java.util.ArrayList;

/**
 *
 * @author Team TNT
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


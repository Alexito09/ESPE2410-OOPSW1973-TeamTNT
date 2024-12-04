/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.sdcardexamp1.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ec.edu.espe.sdcardexamp1.model.SDCard;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
/**
 *
 * @author Leidy Saraguro,Paradigm Pioneers Squad, DCCO-ESPE
 */
public class SDCardStorage {
    private static final String JSON_FILE = "sdCards.json";

    public static void saveToJson(ArrayList<SDCard> sdCards) {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(JSON_FILE)) {
            gson.toJson(sdCards, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<SDCard> readFromJson() {
        Gson gson = new Gson();
        ArrayList<SDCard> sdCards = new ArrayList<>();
        try (FileReader reader = new FileReader(JSON_FILE)) {
            Type listType = new TypeToken<ArrayList<SDCard>>() {}.getType();
            sdCards = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sdCards;
    }
}

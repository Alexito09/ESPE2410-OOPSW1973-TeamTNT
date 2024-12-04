/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.sdcardexamp1.controller;

import ec.edu.espe.sdcardexamp1.model.SDCard;
import ec.edu.espe.sdcardexamp1.utils.SDCardStorage;
import java.util.ArrayList;

/**
 *
 * @author Leidy Saraguro,Paradigm Pioneers Squad, DCCO-ESPE
 */
public class SDCardMenu {
      private SDCardManager sdCardManager;
    private ArrayList<SDCard> sdCards;

    public SDCardMenu() {
        sdCardManager = new SDCardManager();
        sdCards = new ArrayList<>();
    }

    public void run() {
        int option;
        do {
            System.out.println("1. Enter SD Card");
            System.out.println("2. Show SD Cards");
            System.out.println("3. Save to JSON");
            System.out.println("4. Read from JSON");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            option = sdCardManager.enterOption();

            switch (option) {
                case 1:
                    SDCard sdCard = sdCardManager.enterData();
                    sdCards.add(sdCard);
                    break;
                case 2:
                    for (SDCard card : sdCards) {
                        sdCardManager.showSDCard(card);
                    }
                    break;
                case 3:
                    SDCardStorage.saveToJson(sdCards);
                    break;
                case 4:
                    sdCards = SDCardStorage.readFromJson();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 5);
    }
}

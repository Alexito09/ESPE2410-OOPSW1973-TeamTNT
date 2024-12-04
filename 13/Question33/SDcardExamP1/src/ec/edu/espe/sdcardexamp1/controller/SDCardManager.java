/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.sdcardexamp1.controller;

import ec.edu.espe.sdcardexamp1.model.SDCard;
import java.util.Scanner;

/**
 *
 * @author Leidy Saraguro,Paradigm Pioneers Squad, DCCO-ESPE
 */
public class SDCardManager {
    private Scanner scanner;

    public SDCardManager() {
        scanner = new Scanner(System.in);
    }

    public SDCard enterData() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Capacity (GB): ");
        int capacityGB = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        System.out.print("Enter Type: ");
        String type = scanner.nextLine();

        return new SDCard(id, brand, capacityGB, type);
    }

    public void showSDCard(SDCard sdCard) {
        System.out.println(sdCard);
    }

    public int enterOption() {
        return scanner.nextInt();
    }
}

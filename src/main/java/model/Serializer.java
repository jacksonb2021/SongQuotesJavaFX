package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializer {
    private HashMap<String,ArrayList<String>> map;
    private String databasePath = "quotes.ser";

    public Serializer() {
        map = new HashMap<>();

        try {
            FileInputStream rawBytes = new FileInputStream(databasePath); // Read the .ser file just created
            ObjectInputStream inFile = new ObjectInputStream(rawBytes);
            // words = (ArrayList<String>[]) inFile.readObject();
            map = (HashMap<String, ArrayList<String>>) inFile.readObject();
            inFile.close();
            System.out.println("Loaded words");

        } catch (IOException  | ClassNotFoundException ex) {
            saveMap();
        }

    }

    public void saveMap(){
        try {
            FileOutputStream bytesToDisk = new FileOutputStream(databasePath);
            ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
            outFile.writeObject(map);
            outFile.close(); // Always close the output file!
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }


    public HashMap<String,ArrayList<String>> getMap(){
        return this.map;
    }

}











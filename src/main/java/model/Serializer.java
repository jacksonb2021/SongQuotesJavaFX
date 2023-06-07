package model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Serializer {
    //private HashMap<String,ArrayList<String>> map;
    private ArrayList<Quote> list;
    private final String databasePath = "quotes.ser";

    public Serializer() {
        list = new ArrayList<>();

        try {
            FileInputStream rawBytes = new FileInputStream(databasePath); // Read the .ser file just created
            ObjectInputStream inFile = new ObjectInputStream(rawBytes);
            // words = (ArrayList<String>[]) inFile.readObject();
            list = (ArrayList<Quote>) inFile.readObject();
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
            outFile.writeObject(list);
            outFile.close(); // Always close the output file!
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }


    public void exportQuotes(){
        String str = "";
        for(Quote q : list){
            str+=q.getSong() + "\n" + q.getArtist() + "\n" + q.getQuote()+"\n\n";
        }
        try{
            FileWriter fw = new FileWriter("quotes.txt");
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public ArrayList<Quote> getList(){
        return this.list;
    }

}











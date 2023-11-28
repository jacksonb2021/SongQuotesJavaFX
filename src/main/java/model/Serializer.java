package model;

import java.io.*;
import java.util.ArrayList;

import java.util.Scanner;

public class Serializer {
    private ArrayList<Quote> list;
    private final String databasePath = "quotes.ser";

    public Serializer() {
        list = new ArrayList<>();

        try {
            FileInputStream rawBytes = new FileInputStream(databasePath); // Read the .ser file just created
            ObjectInputStream inFile = new ObjectInputStream(rawBytes);
            list = (ArrayList<Quote>) inFile.readObject();
            inFile.close();
            System.out.println("Loaded words");

        } catch (IOException  | ClassNotFoundException ex) {
            saveList();
        }

    }

    public void saveList(){
        try {
            FileOutputStream bytesToDisk = new FileOutputStream(databasePath);
            ObjectOutputStream outFile = new ObjectOutputStream(bytesToDisk);
            outFile.writeObject(list);
            outFile.close(); // Always close the output file!
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

	public void setList(ArrayList<Quote> quotes){
		this.list = quotes;
	}


    public String exportQuotes(String filename){
        String str = "";
        for(Quote q : list){
            str+=q.getSong() + "\n" + q.getArtist() + "\n" + q.getQuote()+"\n\n";
        }
        try{
            FileWriter fw = new FileWriter(parse(filename));
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		return parse(filename);
    }


	private String parse(String str){
		String[]fn= str.split("\\.");
		if(str.equals("")){
			return "quotes.txt";
		}
		if(fn.length==1){
			str+=".txt";
		}
		return str;
	}

	public ArrayList<Quote> importQuotes(String filename){//todo change to allow user input
		Scanner s;
		ArrayList<Quote> quotes = new ArrayList<>();

		try {
			s = new Scanner(new File(parse(filename)));
		}
		catch (IOException e){
			return null;
		}
		String str = "";
		while(s.hasNext()){
			str+=s.nextLine()+"\n";
		}
		for(String quote : str.split("\n\n")){
			String[]split = quote.split("\n");
			Quote q = new Quote(split[0],split[1],split[2]);
			quotes.add(q);
		}
		this.list=quotes;
		return quotes;
	}



    public ArrayList<Quote> getList(){
        return this.list;
    }

}











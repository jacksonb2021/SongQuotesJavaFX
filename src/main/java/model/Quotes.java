package model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quotes {

    HashMap<String, ArrayList<String>> quotes;
    Serializer ser;


    public Quotes(){
        ser = new Serializer();
        quotes = ser.getMap();



    }

    public void save(){
        ser.saveMap();


    }


    public void setQuotes(HashMap<String,ArrayList<String> > quote){
        this.quotes = quote;

    }

    public void addQuote(String song, String quote){
        if(quotes.containsKey(song)) {
            quotes.get(song).add(quote);
        }
        else{
            ArrayList<String> newQuote = new ArrayList<>();
            newQuote.add(quote);
            quotes.put(song, newQuote);
        }
    }


    public ArrayList<String> getQuotes(String song){
        return quotes.get(song);
    }

    public HashMap<String,ArrayList<String>> getMap(){
        return quotes;
    }

    public void deleteSong(String title){
        quotes.remove(title);
    }

    public void deleteQuote(String title, String quote){
        quotes.get(title).remove(quote);

    }

    public void deleteQuoteByIndex(String title, int index){
        quotes.get(title).remove(index);

    }

    public String toString(){
        String str = "";
        for(Map.Entry<String, ArrayList<String>> entry : quotes.entrySet()){
            String key = entry.getKey();
            str +=key+'\n';
            ArrayList<String> value = entry.getValue();
            for(String s : value){
                str += "\t"+s + '\n';
            }
        }
        return str;
    }

}

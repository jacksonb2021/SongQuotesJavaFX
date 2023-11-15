package model;


import java.util.ArrayList;
import java.util.HashMap;

public class Quotes {

    HashMap<String, ArrayList<Quote>> map;
    ArrayList<Quote> quotes;
    Serializer ser;



    public Quotes(){
        ser = new Serializer();
        quotes = ser.getList();
//        map = new HashMap<>();
//        //arr = new ArrayList<Quote>();
//        for(Quote q : quotes){
//            if(map.containsKey(q.getSong())){
//                map.get(q.getSong()).add(q);
//            }
//            else{
//                map.put(q.getSong(), new ArrayList<>());
//            }
//        }




    }


    public void save(){
        ser.saveMap();
    }

	public void clearQuotes(){
		quotes = new ArrayList<>();
	}

    public void exportQuotes(String a){
        ser.exportQuotes(a);
    }
	public boolean importQuotes(String text){
		return ser.importQuotes(text);
	}

    public int size(){
        return quotes.size();
    }



    public void addQuote(String song, String author, String quote){

        quotes.add(new Quote(song,author, quote));
    }



    public ArrayList<Quote> getList(){
        return quotes;
    }



    public void deleteQuote(Quote quote){
        quotes.remove(quote);

    }

    public Quote getQuote(String songstr, String artiststr, String quotestr) {
        for(Quote q : quotes){
            if(q.getSong().equals(songstr) && q.getArtist().equals(artiststr) && q.getQuote().equals(quotestr)){
                return q;
            }
        }
        return null;
    }

//    public void deleteQuoteByIndex(String title, int index){
//        quotes.get(title).remove(index);
//
//    }

//    public String toString(){
//        String str = "";
//        for(Map.Entry entry : map.entrySet()){
//            String key = q.getSong()+" ("+q.getArtist()+")\n";
//            ArrayList<String> value = entry.getValue();
//            for(String s : value){
//                str += "\t"+s + '\n';
//            }
//        }
//        return str;
//    }

}

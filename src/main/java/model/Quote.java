package model;

import java.io.Serializable;

public class Quote implements Serializable {
    private String song;
    private String quote;
    private String artist;

    public Quote(String song, String artist, String quote){
        this.song = song;
        this.quote = quote;
        this.artist = artist;

    }

    public String getSong(){
        return song;
    }

    public String getQuote(){
        return quote;
    }

    public String getArtist(){return artist; }
}

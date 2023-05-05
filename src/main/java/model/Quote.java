package model;

import java.io.Serializable;

public class Quote implements Serializable {
    private final String song;
    private final String quote;
    private final String artist;

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

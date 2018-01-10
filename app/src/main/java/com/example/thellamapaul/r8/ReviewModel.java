package com.example.thellamapaul.r8;

/**
 * Created by thellamapaul on 1/9/2018.
 */

public class ReviewModel {

    private String ID, artist, album, genre, score, arworkAddress, opinion;
    public String getID() {
        return ID;
    }
    public String getArtist() {
        return artist;
    }
    public String getAlbum(){
        return album;
    }
    public String getScore(){
        return score;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setAlbum(String album) {
        this.album = album;
    }
    public void setScore(String score){
        this.score = score;
    }

}

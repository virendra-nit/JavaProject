package com.model;

/**
 *
 * @author viru
 */
public class EventCreatePojo {

    private String userid;

    private String message;

    private String movieName;

    private String posterImg;

    private String[] invities;

    private String dateTime;

    private String rating;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getPosterImg() {
        return posterImg;
    }

    public void setPosterImg(String posterImg) {
        this.posterImg = posterImg;
    }

    public String[] getInvities() {
        return invities;
    }

    public void setInvities(String[] invities) {
        this.invities = invities;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "[userid = " + userid + "message = " + message + ", movieName = " + movieName + ", posterImg = " + posterImg + ", invities = " + invities + ", dateTime = " + dateTime + ", rating = " + rating + "]";
    }

}

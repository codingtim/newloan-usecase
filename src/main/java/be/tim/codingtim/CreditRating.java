package be.tim.codingtim;

public class CreditRating {

    private int rating;

    public CreditRating(int rating) {
        this.rating = rating;
    }

    public boolean isRatingEqualToOrAbove(int rating) {
        return this.rating >= rating;
    }
}

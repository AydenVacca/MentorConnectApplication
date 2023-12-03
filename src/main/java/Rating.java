package MentorConnect;

public class Rating {
    private double rating;
    private int userID;

    //Method for user to rate a mentor
    public void createRating(int mentorID, double rating){
        this.rating=rating;
    }
    //Method for rating deletion
    public void deleteRating(Rating rating){
        rating=null;
    }
    public void editRating(Rating rating, int mentorID, double rating){

    }
    public Rating displayRating(){
        return Rating;
    }
}

package MentorConnect;

import java.util.List;

public class Mentee extends User {

    private int menteeID;
    private String menteeName;
    private List<Rating> ratings;

    //Constructor
    public Mentee(int userID, int menteeID, String menteeName) {
        super(userID);
        this.menteeID = menteeID;
        this.menteeName = menteeName;
    }

    //Getter for menteeID
    public int getMenteeID() {
        return menteeID;
    }

    //Setter for menteeID
    public void setMenteeID(int menteeID) {
        this.menteeID = menteeID;
    }

    //Getter for menteeName
    public String getMenteeName() {
        return menteeName;
    }

    //Setter for menteeName
    public void setMenteeName(String menteeName) {
        this.menteeName = menteeName;
    }

    //Getter for ratings
    public List<Rating> getRatings() {
        return ratings;
    }

    //Setter for ratings
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    //Method implementations
    @Override public void login() {
        
    }
    @Override public void logout() {
        
    }
    @Override public void updateProfile() {
    
    }
}

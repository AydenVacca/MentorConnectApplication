package MentorConnect;

import java.util.List;

public abstract class User {

    //Variables
    private int userID;
    private List<ForumPost> favoritedForums;
    private List<Comment> comments;

    //Constructor
    public User(int userID) {
        this.userID = userID;
    }

    //Getter for userID
    public int getUserID() {
        return userID;
    }

    //Setter for userID
    public void setUserID(int userID) {
        this.userID = userID;
    }

    //Getter for favoritedForums
    public List<ForumPost> getFavoritedForums() {
        return favoritedForums;
    }

    //Setter for favoritedForums
    public void setFavoritedForums(List<ForumPost> favoritedForums) {
        this.favoritedForums = favoritedForums;
    }

    //Getter for comments
    public List<Comment> getComments() {
        return comments;
    }

    //Setter for comments
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
    
    //not sure implementation for this yet
    public abstract boolean login();
    public abstract void logout();
    public abstract void updateProfile();
}

package MentorConnect;

public class Comment {
    //Variables
    private int commentID;
    private User user;
    private String content;
    private int upvotes;
    private int downvotes;
    
    //Constructor
    public Comment(int CommmentID, User user) {
        this.commentID = commentID;
        this.user = user;
    }

    //Upvote method(I am assuming we will have to edit our Class Diagram because we need likely
    // will need commentID as a parameter)
    public void upvote(){
        upvotes++;
    }
    //Downvote method(same thing as above)
    public void downvotes(){
        downvotes++;
    }
}
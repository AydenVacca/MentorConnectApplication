import java.util.List;

public class Mentor extends User {

    private int mentorID;
    private String mentorName;
    private String hoursAvailable;
    private List<Rating> rated;

    //Constructor
    public Mentor(int userID, int mentorID, String mentorName) {
        super(userID);
        this.mentorID = mentorID;
        this.mentorName = mentorName;
    }

    //Getter for mentorID
    public int getMentorID() {
        return mentorID;
    }

    //Setter for mentorID
    public void setMentorID(int mentorID) {
        this.mentorID = mentorID;
    }

    //Getter for mentorName
    public String getMentorName() {
        return mentorName;
    }

    //Setter for mentorName
    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    //Getter for hoursAvailable
    public String getHoursAvailable() {
        return hoursAvailable;
    }

    //Setter for hoursAvailable
    public void setHoursAvailable(String hoursAvailable) {
        this.hoursAvailable = hoursAvailable;
    }

    //Getter for rated
    public List<Rating> getRated() {
        return rated;
    }

    //Setter for rated
    public void setRated(List<Rating> rated) {
        this.rated = rated;
    }

    //Method implementations
    @Override public boolean login() {

    }
    @Override public void logout() {

    }
    @Override public void updateProfile() {

    }

    //Updates the mentors availability
    public void updateHours(String newHours) {
        this.hoursAvailable = newHours;
    }
}

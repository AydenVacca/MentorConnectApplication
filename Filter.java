package MentorConnect;

import java.util.List;

public abstract class Filter {
    protected int mentorID;
    protected String mentorName;
    protected String hoursAvailable;
    protected String storageName;

    // Constructor
    public Filter(int mentorID, String mentorName, String hoursAvailable, String storageName) {
        this.mentorID = mentorID;
        this.mentorName = mentorName;
        this.hoursAvailable = hoursAvailable;
        this.storageName = storageName;
    }

    // Abstract method 'filter' that needs to be implemented in derived classes
    public abstract List<Mentor> filter(Availability param);
}

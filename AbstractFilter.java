public abstract class AbstractFilter {
    // Attributes of the Filter class as inferred from the diagram
    protected String mentorID;
    protected String mentorName;
    protected String storageName;

    // Constructor
    public AbstractFilter(String mentorID, String mentorName, String storageName) {
        this.mentorID = mentorID;
        this.mentorName = mentorName;
        this.storageName = storageName;
    }

    // Abstract method declarations
    // These methods should be implemented by concrete subclasses
    public abstract Mentor filterMentors(String searchKey);
    public abstract Availability filterByAvailability();
    public abstract Mentor filterByHoursAvailable();
    
    // Possible getters and setters for the attributes
    public String getMentorID() {
        return mentorID;
    }

    public void setMentorID(String mentorID) {
        this.mentorID = mentorID;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getStorageName() {
        return storageName;
    }

    public void setStorageName(String storageName) {
        this.storageName = storageName;
    }
    
    // Other possible methods and logic relevant to the Filter class
}

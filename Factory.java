package MentorConnect;

// Factory class to create service instances
public class Factory {
    private Database database;

    public Factory(Database database) {
        this.database = database;
    }

    public SearchService createSearchService() {
        return new SearchService(database);
    }

    public AppointmentService createAppointmentService() {
        return new AppointmentService(database);
    }

    public AcctService createAcctService() {
        return new AcctService(database);
    }

    public ForumPostService createForumPostService() {
        return new ForumPostService(database);
    }
}
// Factory class to create service instances
public class Factory {
    private Databases database;

    public Factory(Databases database) {
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
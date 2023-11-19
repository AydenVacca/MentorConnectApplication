package MentorConnect;

public class SearchService {
    private Factory factory;

    // Constructor to initialize the Factory
    public SearchService(Factory factory) {
        this.factory = factory;
    }

    // Public method to search for a mentor by name
    public Mentor searchMentor(String mentorName) {
        return Factory.getMentorByName(mentorName);
    }
}
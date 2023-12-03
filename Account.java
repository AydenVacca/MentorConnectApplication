public abstract class Account{
    //Variables
    private String username;
    private String password;

    //Default Constructor(not sure what to add here)
    public Account(){

    }
    //Method to Create a new Account
    public void createAcc(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    //Method to delete a user's account(possibly think about adding userID as a parameter)
    public void deleteAcc(){
        
    }


}
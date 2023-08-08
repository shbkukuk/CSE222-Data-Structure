public class Interaction {
    /** Interaction is a class that represents a interactive relation between accounts  */
    //Data Field
    public  int interactionId;
    protected  Account account;
    public  int postId; 
    /**
    //Constructors:
    @param interID ID of interaction
    @param acccount Account class of object
    @param pstID ID of  Post
     */
    public Interaction(int interID, Account account, int pstID){
        interactionId = interID;
        this.account = account;
        postId = pstID;
    }
}


